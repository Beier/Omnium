using System.Linq;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class AstValidator : TreeVoidWalker
    {
        public override void ExitMethodDeclaration(MethodDeclaration methodDeclaration)
        {
            foreach (var duplicates in methodDeclaration.GenericTypeDeclarations.GetDuplicatesBy(x => x.Name))
            {
                Errors.Add(new CompilationError(methodDeclaration.Context, "Duplicate generic declarations: " + duplicates.Key));
            }
            foreach (var duplicates in methodDeclaration.Variables.GetDuplicatesBy(x => x.Name))
            {
                Errors.Add(new CompilationError(methodDeclaration.Context, "Duplicate parameter declarations: " + duplicates.Key));
            }

            bool foundParameterWithDefaultValue = false;
            foreach (var parameter in methodDeclaration.Variables)
            {
                if (parameter.InitExpression != null)
                    foundParameterWithDefaultValue = true;
                else if (foundParameterWithDefaultValue)
                {
                    Errors.Add(new CompilationError(methodDeclaration.Context, "Default parameters must be the last parameters in the method."));
                    break;
                }
            }

            if (!(methodDeclaration.ReturnType is VoidType) && !DoAllPathsReturnAValue(methodDeclaration.Body))
                Errors.Add(new CompilationError(methodDeclaration.Context, "Not all paths return a value"));
        }

        private bool DoAllPathsReturnAValue(INode node)
        {
            if (!(node is IStatement))
                return false;
            switch (node)
            {
                case ReturnStatement returnStatement:
                    if (returnStatement.Value == null)
                        Errors.Add(new CompilationError(returnStatement.Context, "Return statement must return a value"));
                    return true;
                case BlockStatement blockStatement:
                    foreach (var statement in blockStatement.Statements.ToList())
                    {
                        if (DoAllPathsReturnAValue(statement))
                        {
                            foreach (var statementAfterReturn in blockStatement.Statements.SkipWhile(x => x != statement).Skip(1).ToList())
                            {
                                statementAfterReturn.Remove();
                            }

                            return true;
                        }
                    }
                    return false;
                case IfStatement ifStatement:
                    if (ifStatement.FalseBranch == null)
                        return false;
                    return DoAllPathsReturnAValue(ifStatement.TrueBranch) && DoAllPathsReturnAValue(ifStatement.FalseBranch);
                case SwitchStatement switchStatement:
                    if (!switchStatement.Groups.Any())
                        return false;
                    //If no default is specified, we can not be sure that any of the alternatives will be picked
                    if (!switchStatement.Groups.Any(x => x.Labels.Any(y => y.condition == null)))
                        return false;
                    return switchStatement.Groups.All(DoAllPathsReturnAValue);
                case SwitchGroup switchGroup:
                    return switchGroup.Statements.Any(DoAllPathsReturnAValue);
            }
            return false;
        }

        public override void ExitConstructorDeclaration(ConstructorDeclaration constructorDeclaration)
        {
            foreach (var duplicates in constructorDeclaration.Parameters.GetDuplicatesBy(x => x.Name))
            {
                Errors.Add(new CompilationError(constructorDeclaration.Context, "Duplicate parameter declarations: " + duplicates.Key));
            }
        }

        public override void ExitClassDeclaration(ClassDeclaration classDeclaration)
        {
            foreach (var duplicates in classDeclaration.MethodDeclarations.GetDuplicatesBy(x => x.Name))
            {
                Errors.Add(new CompilationError(classDeclaration.Context, "Typescript does not support method overloads: " + duplicates.Key));
            }
            foreach (var duplicates in classDeclaration.Getters.GetDuplicatesBy(x => x.Name))
            {
                Errors.Add(new CompilationError(classDeclaration.Context, "Duplicate getter declarations: " + duplicates.Key));
            }
            foreach (var duplicates in classDeclaration.Setters.GetDuplicatesBy(x => x.Name))
            {
                Errors.Add(new CompilationError(classDeclaration.Context, "Duplicate setter declarations: " + duplicates.Key));
            }
            if (classDeclaration.Constructors.Count() > 1)
                Errors.Add(new CompilationError(classDeclaration.Context, "Constructor overloads are not supported"));
            foreach (var getterSetter in classDeclaration.GettersAndSetters)
            {
                if (getterSetter.Getter == null || getterSetter.Setter == null)
                    break;
                foreach (var getterModifier in getterSetter.Getter.Modifiers)
                {
                    if (!getterSetter.Setter.Modifiers.Contains(getterModifier))
                        Errors.Add(new CompilationError(getterSetter.Getter.Context, $"Modifier {getterModifier} found on getter, but not on setter"));
                }
                foreach (var setterModifier in getterSetter.Setter.Modifiers)
                {
                    if (!getterSetter.Getter.Modifiers.Contains(setterModifier))
                        Errors.Add(new CompilationError(getterSetter.Setter.Context, $"Modifier {setterModifier} found on setter, but not on getter"));
                }
            }

            foreach (var child in classDeclaration.Children)
            {
                var modifiers = child.Yield().Select(
                    (ConstructorDeclaration declaration) => declaration.Modifiers,
                    (GetterDeclaration declaration) => declaration.Modifiers,
                    (SetterDeclaration declaration) => declaration.Modifiers,
                    (MethodDeclaration declaration) => declaration.Modifiers,
                    (VariableDeclaration declaration) => declaration.Modifiers
                ).Single();
                if (modifiers.Contains(MemberModifier.Public) && modifiers.Contains(MemberModifier.Private))
                    Errors.Add(new CompilationError(child.Context, "Class member can not be marked as both public and private"));
                for (int i = 0; i < modifiers.Count; i++)
                {
                    for (int j = i + 1; j < modifiers.Count; j++)
                    {
                        if (modifiers[i] == modifiers[j])
                            Errors.Add(new CompilationError(child.Context, "Duplicated modifier: " + modifiers[i].ToString().ToLower()));
                    }
                }
            }
        }

        public override void ExitModuleDeclaration(ModuleDeclaration moduleDeclaration)
        {
            foreach (var duplicates in moduleDeclaration.ClassDeclarations.GetDuplicatesBy(x => x.Name))
            {
                Errors.Add(new CompilationError(moduleDeclaration.Context, "Two class can not have the same name: " + duplicates.Key));
            }
            foreach (var duplicates in moduleDeclaration.EnumDeclarations.GetDuplicatesBy(x => x.Name))
            {
                Errors.Add(new CompilationError(moduleDeclaration.Context, "Two enums can not have the same name: " + duplicates.Key));
            }
        }

        public override void ExitBreakStatement(BreakStatement breakStatement)
        {
            var loopStatement = breakStatement.NearestAncestorOfAnyType(typeof(ForStatement), typeof(ForeachStatement), typeof(WhileStatement), typeof(SwitchStatement));
            if (loopStatement == null)
                Errors.Add(new CompilationError(breakStatement.Context, "Break statements can only appear inside loops or a switch statement"));
        }

        public override void ExitContinueStatement(ContinueStatement continueStatement)
        {
            var loopStatement = continueStatement.NearestAncestorOfAnyType(typeof(ForStatement), typeof(ForeachStatement), typeof(WhileStatement));
            if (loopStatement == null)
                Errors.Add(new CompilationError(continueStatement.Context, "Continue statements can only appear inside loops"));
        }
    }
}