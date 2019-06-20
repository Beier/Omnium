using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.expressions.literals;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class NativeLoader : TreeVoidWalker
    {
        public override void ExitMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression)
        {
            if (!(methodInvocationExpression.Base.Value is MemberExpression memberExpression)
                || !(memberExpression.Base.Value is SimpleNameExpression simpleNameExpression)
                || simpleNameExpression.Name != "Native")
                return;
            var nativeFunctionCallRegex = new Regex("^callNativeArg(\\d+)(Function|Action)$");
            if (nativeFunctionCallRegex.IsMatch(memberExpression.Name))
            {
                var matchGroups = nativeFunctionCallRegex.Match(memberExpression.Name).Groups;
                var numberOfArguments = int.Parse(matchGroups[1].Value);
                var hasReturnType = matchGroups[2].Value == "Function";
                var expectedNumberOfGenericArguments = numberOfArguments + (hasReturnType ? 1 : 0);
                if (methodInvocationExpression.GenericTypes.Count != expectedNumberOfGenericArguments)
                {
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, $"Expected {expectedNumberOfGenericArguments} generic type arguments."));
                    return;
                }

                if (methodInvocationExpression.Arguments.Count < numberOfArguments + 1 ||
                    methodInvocationExpression.Arguments.Count > numberOfArguments + 2)
                {
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, $"Expected {numberOfArguments + 1} - {numberOfArguments + 2} arguments."));
                    return;
                }

                if (!(methodInvocationExpression.Arguments[0] is StringLiteral namExpression))
                {
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, "First argument must be a string literal."));
                    return;
                }

                //Todo: Check if arguments are assignable
                methodInvocationExpression.ReplaceWith(
                    new NativeMethodInvocationExpression(
                        methodInvocationExpression.Context,
                        namExpression.Text.Substring(1, namExpression.Text.Length - 2),
                        methodInvocationExpression.GenericTypes.Take(numberOfArguments),
                        methodInvocationExpression.Arguments.Skip(1).Take(numberOfArguments),
                        hasReturnType ? methodInvocationExpression.GenericTypes.Last() : new VoidType(methodInvocationExpression.Context)
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
                if (methodInvocationExpression.GenericTypes.Count != expectedNumberOfGenericArguments)
                {
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, $"Expected {expectedNumberOfGenericArguments} generic type arguments."));
                    return;
                }

                if (methodInvocationExpression.Arguments.Count != 2)
                {
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, "Expected 2 arguments."));
                    return;
                }

                if (!(methodInvocationExpression.Arguments[0] is StringLiteral namExpression))
                {
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, "First argument must be a string literal."));
                    return;
                }
                var typescriptNames = new List<string>();
                var typescriptNameExpression = methodInvocationExpression.Arguments[1];
                while (true)
                {
                    if (typescriptNameExpression is MemberExpression typescriptNameMemberExpression)
                    {
                        typescriptNames.Insert(0, typescriptNameMemberExpression.Name);
                        typescriptNameExpression = typescriptNameMemberExpression.Base.Value;
                    }
                    else if (typescriptNameExpression is SimpleNameExpression typescriptNameSimpleExpression)
                    {
                        typescriptNames.Insert(0, typescriptNameSimpleExpression.Name);
                        break;
                    }
                    else
                    {
                        Errors.Add(new CompilationError(methodInvocationExpression.Context, "Last argument can only consist of simple names. Ex. Math.abs"));
                        break;
                    }
                }

                var root = methodInvocationExpression.NearestAncestorOfType<Root>();
                methodInvocationExpression.Remove();
                root.NativeMethods.Add(
                    new NativeMethodDeclaration(
                        methodInvocationExpression.Context,
                        namExpression.Text.Substring(1, namExpression.Text.Length - 2),
                        typescriptNames,
                        methodInvocationExpression.GenericTypes.Take(numberOfArguments),
                        hasReturnType ? methodInvocationExpression.GenericTypes.Last() : new VoidType(methodInvocationExpression.Context)
                    )
                );
                return;
            }

            if (memberExpression.Name == "rule")
            {
                if (methodInvocationExpression.GenericTypes.Count != 0)
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, "Expected 0 generic type arguments."));

                if (methodInvocationExpression.Arguments.Count != 3 && methodInvocationExpression.Arguments.Count != 4)
                {
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, "Expected 3-4 arguments (name, trigger, [condition], action)."));
                    return;
                }
                if (!(methodInvocationExpression.Arguments[0] is StringLiteral namExpression))
                {
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, "First argument must be a string literal."));
                    return;
                }

                if (!(methodInvocationExpression.Parent is SourceFile parent))
                {
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, "Rules must be defined in the root of a file."));
                    return;
                }

                parent.MethodInvocations.Remove(methodInvocationExpression);
                parent.RuleDeclarations.Add(
                    new RuleDeclaration(
                        methodInvocationExpression.Context,
                        namExpression.Text.Substring(1, namExpression.Text.Length - 2),
                        methodInvocationExpression.Arguments[1],
                        methodInvocationExpression.Arguments.Count == 3 ? null : methodInvocationExpression.Arguments[2],
                        methodInvocationExpression.Arguments.Last()
                    )
                );
            }
            if (memberExpression.Name == "debugExecute")
            {
                methodInvocationExpression.Remove();
            }
        }

        public override void ExitModuleDeclaration(ModuleDeclaration moduleDeclaration)
        {
            if (moduleDeclaration.Name == "Native")
            {
                moduleDeclaration.Remove();
            }
        }
    }
}