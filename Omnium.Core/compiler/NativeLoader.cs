using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler
{
    public class NativeLoader : TreeVoidWalker
    {
        private readonly Regex nativeFunctionCallRegex = new Regex("^callNativeArg(\\d+)(Function|Action)$");

        private readonly Regex nativeFunctionDefinitionRegex = new Regex("^defineTypescriptNativeArg(\\d+)(Function|Action)$");

        public override void ExitMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression)
        {
            if (!(methodInvocationExpression.Base is MemberExpression memberExpression)
                || !(memberExpression.Base is SimpleNameExpression simpleNameExpression)
                || simpleNameExpression.Name != "Native")
                return;
            switch (memberExpression.Name)
            {
                case var name when nativeFunctionCallRegex.IsMatch(name):
                    ReplaceCallToNativeFunction(methodInvocationExpression);
                    break;
                case var name when nativeFunctionDefinitionRegex.IsMatch(name):
                    RegisterNativeFunction(methodInvocationExpression);
                    break;
                case "rule":
                    CreateRuleDeclaration(methodInvocationExpression);
                    break;
                case "debugExecute":
                    methodInvocationExpression.Remove();
                    break;
                case "trigger":
                    ConvertToNativeTrigger(methodInvocationExpression);
                    break;
                case "playerTrigger":
                    ConvertToPlayerTrigger(methodInvocationExpression);
                    break;
                case "registerString":
                    RegisterString(methodInvocationExpression);
                    break;
                case "assert":
                    ConvertToAssersion(methodInvocationExpression);
                    break;
            }
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

        private void ReplaceCallToNativeFunction(MethodInvocationExpression methodInvocationExpression)
        {
            var context = methodInvocationExpression.Context;
            var memberExpression = (MemberExpression)methodInvocationExpression.Base;
            var matchGroups = nativeFunctionCallRegex.Match(memberExpression.Name).Groups;
            var numberOfArguments = int.Parse(matchGroups[1].Value);
            var hasReturnType = matchGroups[2].Value == "Function";
            var expectedNumberOfGenericArguments = numberOfArguments + (hasReturnType ? 1 : 0);

            if (hasReturnType
                    ? !ValidateSignature<IStatement, IExpression>(methodInvocationExpression, expectedNumberOfGenericArguments, numberOfArguments + 3, numberOfArguments + 4)
                    : !ValidateSignature<ExpressionStatement>(methodInvocationExpression, expectedNumberOfGenericArguments, numberOfArguments + 3, numberOfArguments + 4))
                return;

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
            var changesState = ((BooleanLiteral)methodInvocationExpression.Arguments.AtIndex(2)).Value;

            if (NativeMethods.ModifyingControlFlow.Contains(nativeMethodName))
            {
                Errors.Add(new CompilationError(context,
                    "Native methods that modify control flow are restricted. Use if/for/foreach/while to modify control flow."));
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
        }

        private void RegisterNativeFunction(MethodInvocationExpression methodInvocationExpression)
        {
            var context = methodInvocationExpression.Context;
            var memberExpression = (MemberExpression)methodInvocationExpression.Base;
            var matchGroups = nativeFunctionDefinitionRegex.Match(memberExpression.Name).Groups;
            var numberOfArguments = int.Parse(matchGroups[1].Value);
            var hasReturnType = matchGroups[2].Value == "Function";
            var expectedNumberOfGenericArguments = numberOfArguments + (hasReturnType ? 1 : 0);

            if (!ValidateSignature<SourceFile>(methodInvocationExpression, expectedNumberOfGenericArguments, 4))
                return;

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
                Errors.Add(new CompilationError(context,
                    "Native methods that modify control flow are restricted. Use if/for/foreach/while to modify control flow."));
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
                parameterTypes.SelectMany((x, i) => new INode[]
                    {AstCloner.Clone(x), new SimpleNameExpression(context, "param" + i)})
            );
            var statement = hasReturnType
                ? (IStatement)new ReturnStatement(context, nativeMethodInvocationExpression.Yield())
                : new ExpressionStatement(context, nativeMethodInvocationExpression);


            var methodDeclaration = new MethodDeclaration(
                context,
                typescriptNames.Last(),
                parameterTypes.Select((x, i) => new VariableDeclaration(context, "param" + i, AstCloner.Clone(x).Yield()))
                    .Concat<INode>(returnType.Yield())
                    .Concat(new BlockStatement(context, statement.Yield()).Yield())
            );
            methodDeclaration.Modifiers.Add(MemberModifier.Static);
            container.AddChild(
                methodDeclaration
            );
            methodInvocationExpression.Remove();
        }

        private void CreateRuleDeclaration(MethodInvocationExpression methodInvocationExpression)
        {
            var context = methodInvocationExpression.Context;
            if (!ValidateSignature<SourceFile>(methodInvocationExpression, 0, 3, 4))
                return;

            if (!(methodInvocationExpression.Arguments.First() is StringLiteral namExpression))
            {
                Errors.Add(new CompilationError(context, "First argument must be a string literal."));
                return;
            }

            var arguments = methodInvocationExpression.Arguments.Skip(1).ToList();
            if (arguments.Count == 2)
                arguments.Insert(1, new BooleanLiteral(context, true));

            methodInvocationExpression.Parent.AddChild(
                new RuleDeclaration(
                    context,
                    namExpression.Text.Substring(1, namExpression.Text.Length - 2),
                    arguments
                )
            );
            methodInvocationExpression.Remove();
        }

        private void ConvertToNativeTrigger(MethodInvocationExpression methodInvocationExpression)
        {
            var context = methodInvocationExpression.Context;
            if (!ValidateSignature<IStatement, IExpression>(methodInvocationExpression, 0, 1))
                return;

            if (!(methodInvocationExpression.Arguments.First() is StringLiteral nameExpression))
            {
                Errors.Add(new CompilationError(context, "The argument must be a string literal."));
                return;
            }

            var nativeMethodName = nameExpression.Text.Substring(1, nameExpression.Text.Length - 2);
            var trigger = new NativeTrigger(context, nativeMethodName, new INode[0]);
            methodInvocationExpression.ReplaceWith(trigger);
        }

        private void ConvertToPlayerTrigger(MethodInvocationExpression methodInvocationExpression)
        {
            var context = methodInvocationExpression.Context;
            if (!ValidateSignature<IStatement, IExpression>(methodInvocationExpression, 0, 3))
                return;

            if (!(methodInvocationExpression.Arguments.First() is StringLiteral nameExpression))
            {
                Errors.Add(new CompilationError(context, "The argument must be a string literal."));
                return;
            }

            var nativeMethodName = nameExpression.Text.Substring(1, nameExpression.Text.Length - 2);
            var trigger = new NativeTrigger(context, nativeMethodName, methodInvocationExpression.Arguments.Skip(1));
            methodInvocationExpression.ReplaceWith(trigger);
        }

        private void RegisterString(MethodInvocationExpression methodInvocationExpression)
        {
            var context = methodInvocationExpression.Context;
            if (!ValidateSignature<SourceFile>(methodInvocationExpression, 0, 1))
                return;

            if (!(methodInvocationExpression.Arguments.First() is StringLiteral nameExpression))
            {
                Errors.Add(new CompilationError(context, "The argument must be a string literal."));
                return;
            }

            var root = methodInvocationExpression.NearestAncestorOfType<Root>();
            root.NativeStrings.Add(nameExpression.UnquotedText);
            methodInvocationExpression.Remove();
        }

        private void ConvertToAssersion(MethodInvocationExpression methodInvocationExpression)
        {
            var context = methodInvocationExpression.Context;
            if (!ValidateSignature<ExpressionStatement>(methodInvocationExpression, 0, 1, 2))
                return;

            if (methodInvocationExpression.Arguments.Count() == 2 &&
                !(methodInvocationExpression.Arguments.ElementAt(1) is StringLiteral))
            {
                Errors.Add(new CompilationError(context, "The message argument must be a string literal."));
                return;
            }

            methodInvocationExpression.Parent.ReplaceWith(new Assertion(context, methodInvocationExpression.Arguments));
        }
        
        private bool ValidateSignature<T1>(MethodInvocationExpression methodInvocationExpression, int numberOfGenerics, int numberOfArguments)
        {
            return ValidateSignature<T1, T1>(methodInvocationExpression, numberOfGenerics, numberOfArguments, numberOfArguments);
        }

        private bool ValidateSignature<T1, T2>(MethodInvocationExpression methodInvocationExpression, int numberOfGenerics, int numberOfArguments)
        {
            return ValidateSignature<T1, T2>(methodInvocationExpression, numberOfGenerics, numberOfArguments, numberOfArguments);
        }

        private bool ValidateSignature<T1>(MethodInvocationExpression methodInvocationExpression,
            int numberOfGenerics,
            int minNumberOfArguments, int maxNumberOfArguments)
        {
            return ValidateSignature<T1, T1>(methodInvocationExpression, numberOfGenerics, minNumberOfArguments, maxNumberOfArguments);
        }

        private bool ValidateSignature<T1, T2>(MethodInvocationExpression methodInvocationExpression,
            int numberOfGenerics,
            int minNumberOfArguments, int maxNumberOfArguments)
        {
            var context = methodInvocationExpression.Context;
            if (methodInvocationExpression.GenericTypes.Count() != numberOfGenerics)
            {
                var pluralisS = numberOfGenerics == 1 ? "" : "s";
                Errors.Add(new CompilationError(context, $"Expected {numberOfGenerics} generic type argument{pluralisS}."));
                return false;
            }

            var argumentCount = methodInvocationExpression.Arguments.Count();
            if (argumentCount < minNumberOfArguments || argumentCount > maxNumberOfArguments)
            {
                var number = minNumberOfArguments == maxNumberOfArguments
                    ? minNumberOfArguments.ToString()
                    : $"{minNumberOfArguments}-{maxNumberOfArguments}";
                var pluralisS = minNumberOfArguments == 1 && maxNumberOfArguments == 1 ? "" : "s";
                Errors.Add(new CompilationError(context, $"Expected {number} argument{pluralisS}."));
                return false;
            }

            if (!(methodInvocationExpression.Parent is T1 || methodInvocationExpression.Parent is T2))
            {
                Errors.Add(new CompilationError(context, "Invalid call site"));
                return false;
            }

            return true;
        }
    }
}