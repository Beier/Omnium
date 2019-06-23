using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.expressions.literals;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class NativeLoader : TreeVoidWalker
    {
        public override void ExitMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression)
        {
            if (!(methodInvocationExpression.Base is MemberExpression memberExpression)
                || !(memberExpression.Base is SimpleNameExpression simpleNameExpression)
                || simpleNameExpression.Name != "Native")
                return;
            var nativeFunctionCallRegex = new Regex("^callNativeArg(\\d+)(Function|Action)$");
            var context = methodInvocationExpression.Context;
            if (nativeFunctionCallRegex.IsMatch(memberExpression.Name))
            {
                var matchGroups = nativeFunctionCallRegex.Match(memberExpression.Name).Groups;
                var numberOfArguments = int.Parse(matchGroups[1].Value);
                var hasReturnType = matchGroups[2].Value == "Function";
                var expectedNumberOfGenericArguments = numberOfArguments + (hasReturnType ? 1 : 0);
                if (methodInvocationExpression.GenericTypes.Count() != expectedNumberOfGenericArguments)
                {
                    Errors.Add(new CompilationError(context, $"Expected {expectedNumberOfGenericArguments} generic type arguments."));
                    return;
                }

                if (methodInvocationExpression.Arguments.Count() < numberOfArguments + 3 ||
                    methodInvocationExpression.Arguments.Count() > numberOfArguments + 4)
                {
                    Errors.Add(new CompilationError(context, $"Expected {numberOfArguments + 1} - {numberOfArguments + 2} arguments."));
                    return;
                }

                if (!(methodInvocationExpression.Arguments.First() is StringLiteral namExpression))
                {
                    Errors.Add(new CompilationError(context, "First argument must be a string literal."));
                    return;
                }
                if (methodInvocationExpression.Arguments.Skip(1).Take(2).Any(x => !(x is BooleanLiteral)))
                {
                    Errors.Add(new CompilationError(context, "Second and third argument must be boolean literals."));
                    return;
                }

                var nativeMethodName = namExpression.Text.Substring(1, namExpression.Text.Length - 2);
                var readsState = ((BooleanLiteral) methodInvocationExpression.Arguments.AtIndex(1)).Value;
                var changesState = ((BooleanLiteral) methodInvocationExpression.Arguments.AtIndex(2)).Value;
                
                if (NativeMethods.ModifyingControlFlow.Contains(nativeMethodName))
                {
                    Errors.Add(new CompilationError(context, "Native methods that modify control flow are restricted. Use if/for/foreach/while to modify control flow."));
                }

                methodInvocationExpression.ReplaceWith(
                    new NativeMethodInvocationExpression(
                        context,
                        nativeMethodName,
                        hasReturnType ? methodInvocationExpression.GenericTypes.Last() : new VoidType(context),
                        readsState,
                        changesState,
                        false,
                        methodInvocationExpression.GenericTypes.Take(numberOfArguments)
                            .Concat<INode>(methodInvocationExpression.Arguments.Skip(3).Take(numberOfArguments))
                    )
                );
                return;
            }
            var nativeFunctionDefinitionRegex = new Regex("^defineTypescriptNativeArg(\\d+)(Function|Action)$");
            if (nativeFunctionDefinitionRegex.IsMatch(memberExpression.Name))
            {
                var matchGroups = nativeFunctionDefinitionRegex.Match(memberExpression.Name).Groups;
                var numberOfArguments = int.Parse(matchGroups[1].Value);
                var hasReturnType = matchGroups[2].Value == "Function";
                var expectedNumberOfGenericArguments = numberOfArguments + (hasReturnType ? 1 : 0);
                if (methodInvocationExpression.GenericTypes.Count() != expectedNumberOfGenericArguments)
                {
                    Errors.Add(new CompilationError(context, $"Expected {expectedNumberOfGenericArguments} generic type arguments."));
                    return;
                }

                if (methodInvocationExpression.Arguments.Count() != 4)
                {
                    Errors.Add(new CompilationError(context, "Expected 4 arguments."));
                    return;
                }
                if (!(methodInvocationExpression.Parent is SourceFile))
                {
                    Errors.Add(new CompilationError(context, "This method must be called from the root of a file."));
                    return;
                }

                if (!(methodInvocationExpression.Arguments.First() is StringLiteral namExpression))
                {
                    Errors.Add(new CompilationError(context, "First argument must be a string literal."));
                    return;
                }

                if (methodInvocationExpression.Arguments.Skip(1).Take(2).Any(x => !(x is BooleanLiteral)))
                {
                    Errors.Add(new CompilationError(context, "Second and third argument must be boolean literals."));
                    return;
                }

                var nativeMethodName = namExpression.Text.Substring(1, namExpression.Text.Length - 2);
                var readsState = ((BooleanLiteral)methodInvocationExpression.Arguments.AtIndex(1)).Value;
                var changesState = ((BooleanLiteral)methodInvocationExpression.Arguments.AtIndex(1)).Value;

                if (NativeMethods.ModifyingControlFlow.Contains(nativeMethodName))
                {
                    Errors.Add(new CompilationError(context, "Native methods that modify control flow are restricted. Use if/for/foreach/while to modify control flow."));
                }

                var typescriptNames = new List<string>();
                var typescriptNameExpression = methodInvocationExpression.Arguments.Skip(3).First();
                while (true)
                {
                    if (typescriptNameExpression is MemberExpression typescriptNameMemberExpression)
                    {
                        typescriptNames.Insert(0, typescriptNameMemberExpression.Name);
                        typescriptNameExpression = typescriptNameMemberExpression.Base;
                    }
                    else if (typescriptNameExpression is SimpleNameExpression typescriptNameSimpleExpression)
                    {
                        typescriptNames.Insert(0, typescriptNameSimpleExpression.Name);
                        break;
                    }
                    else
                    {
                        Errors.Add(new CompilationError(context, "Last argument can only consist of simple names. Ex. Math.abs"));
                        break;
                    }
                }

                var container = (INode)methodInvocationExpression.NearestAncestorOfType<Root>();
                for (int i = 0; i < typescriptNames.Count - 1; i++)
                {
                    var module = container.Children.OfType<ModuleDeclaration>().SingleOrDefault(x => x.Name == typescriptNames[i]);
                    if (module == null)
                    {
                        module = new ModuleDeclaration(context, typescriptNames[i], new INode[0]);
                        container.AddChild(module);
                    }

                    container = module;
                }

                var parameterTypes = methodInvocationExpression.GenericTypes.Take(numberOfArguments).ToList();
                var returnType = hasReturnType ? methodInvocationExpression.GenericTypes.Last() : new VoidType(context);
                var nativeMethodInvocationExpression = new NativeMethodInvocationExpression(
                    context, 
                    nativeMethodName, 
                    returnType,
                    readsState,
                    changesState,
                    false,
                    parameterTypes.SelectMany((x, i) => new INode[] {AstCloner.Clone(x), new SimpleNameExpression(context, "param" + i)})
                );
                var statement = hasReturnType
                    ? (IStatement) new ReturnStatement(context, nativeMethodInvocationExpression.Yield())
                    : new ExpressionStatement(context, nativeMethodInvocationExpression);


                var methodDeclaration = new MethodDeclaration(
                    context, 
                    typescriptNames.Last(),
                    parameterTypes.Select((x, i) => new VariableDeclaration(context, "param" + i, AstCloner.Clone(x).Yield()))
                        .Concat<INode>(returnType.Yield())
                        .Concat(new BlockStatement(context,statement.Yield()).Yield())
                );
                methodDeclaration.Modifiers.Add(MemberModifier.Static);
                container.AddChild(
                    methodDeclaration
                    );
                methodInvocationExpression.Remove();
                return;
            }
            else if (memberExpression.Name == "rule")
            {
                CreateRuleDeclaration(context, methodInvocationExpression);
            }
            else if (memberExpression.Name == "debugExecute")
            {
                methodInvocationExpression.Remove();
            }
            else if (memberExpression.Name == "trigger")
            {
                if (methodInvocationExpression.GenericTypes.Any())
                {
                    Errors.Add(new CompilationError(context, "Expected no generic type arguments."));
                    return;
                }

                if (methodInvocationExpression.Arguments.Count() != 1)
                {
                    Errors.Add(new CompilationError(context, "Expected 1 arguments."));
                    return;
                }

                if (!(methodInvocationExpression.Arguments.First() is StringLiteral namExpression))
                {
                    Errors.Add(new CompilationError(context, "The argument must be a string literal."));
                    return;
                }
                var nativeMethodName = namExpression.Text.Substring(1, namExpression.Text.Length - 2);
                var trigger = new NativeTrigger(context, nativeMethodName, new INode[0]);
                methodInvocationExpression.ReplaceWith(trigger);
            }
            else if (memberExpression.Name == "playerTrigger")
            {
                if (methodInvocationExpression.GenericTypes.Any())
                {
                    Errors.Add(new CompilationError(context, "Expected no generic type arguments."));
                    return;
                }

                if (methodInvocationExpression.Arguments.Count() != 3)
                {
                    Errors.Add(new CompilationError(context, "Expected 3 arguments."));
                    return;
                }

                if (!(methodInvocationExpression.Arguments.First() is StringLiteral namExpression))
                {
                    Errors.Add(new CompilationError(context, "The argument must be a string literal."));
                    return;
                }
                var nativeMethodName = namExpression.Text.Substring(1, namExpression.Text.Length - 2);
                var trigger = new NativeTrigger(context, nativeMethodName, methodInvocationExpression.Arguments.Skip(1));
                methodInvocationExpression.ReplaceWith(trigger);
            }
            else if (memberExpression.Name == "registerString")
            {
                if (methodInvocationExpression.GenericTypes.Any())
                {
                    Errors.Add(new CompilationError(context, "Expected no generic type arguments."));
                    return;
                }
                if (methodInvocationExpression.Arguments.Count() != 1)
                {
                    Errors.Add(new CompilationError(context, "Expected 1 arguments."));
                    return;
                }
                if (!(methodInvocationExpression.Parent is SourceFile))
                {
                    Errors.Add(new CompilationError(context, "This method must be called from the root of a file."));
                    return;
                }
                if (!(methodInvocationExpression.Arguments.First() is StringLiteral namExpression))
                {
                    Errors.Add(new CompilationError(context, "The argument must be a string literal."));
                    return;
                }

                var root = methodInvocationExpression.NearestAncestorOfType<Root>();
                root.NativeStrings.Add(namExpression.UnquotedText);
                methodInvocationExpression.Remove();
            }
        }

        private void CreateRuleDeclaration(IParseTree context, MethodInvocationExpression methodInvocationExpression)
        {
            if (methodInvocationExpression.GenericTypes.Count() != 0)
                Errors.Add(new CompilationError(context, "Expected 0 generic type arguments."));

            if (methodInvocationExpression.Arguments.Count() != 4)
            {
                Errors.Add(new CompilationError(context, "Expected 4 arguments."));
                return;
            }

            if (!(methodInvocationExpression.Arguments.First() is StringLiteral namExpression))
            {
                Errors.Add(new CompilationError(context, "First argument must be a string literal."));
                return;
            }

            if (!(methodInvocationExpression.Parent is SourceFile parent))
            {
                Errors.Add(new CompilationError(context, "Rules must be defined in the root of a file."));
                return;
            }

            methodInvocationExpression.Remove();
            parent.AddChild(
                new RuleDeclaration(
                    context,
                    namExpression.Text.Substring(1, namExpression.Text.Length - 2),
                    methodInvocationExpression.Arguments.Skip(1)
                )
            );
        }

        public override void ExitModuleDeclaration(ModuleDeclaration moduleDeclaration)
        {
            if (moduleDeclaration.Name == "Native")
            {
                var root = moduleDeclaration.NearestAncestorOfType<Root>();
                moduleDeclaration.Remove();
                root.NativeModule = moduleDeclaration;
            }
        }
    }
}