using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;
using Omnium.Core.compiler.utilities;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler.step2TypeAssignment.expressionTypeAssignerAndMethodLinker
{
    public partial class ExpressionTypeAssignerAndMethodLinker : TreeVoidWalker
    {
        public override void ExitSimpleNameExpression(SimpleNameExpression simpleNameExpression)
        {
            if (simpleNameExpression.Declarations.Any())
                return;
            var ancestors = simpleNameExpression.AllAncestorsAndSelf()
                .OfAnyType(typeof(IHasVariables),
                typeof(ClassDeclaration),
                typeof(ModuleDeclaration),
                typeof(SourceFile),
                typeof(Root));

            foreach (var ancestor in ancestors)
            {
                var declarations = GetMatchingDeclarations(ancestor, simpleNameExpression, simpleNameExpression.Name, true);
                if (!declarations.Any())
                    continue;
                if (declarations.Count > 1 && declarations.NotOfType(typeof(ITypeDeclaration)).Any())
                    Errors.Add(new CompilationError(simpleNameExpression.Context, $"Found multiple declarations matching '{simpleNameExpression.Name}'"));

                simpleNameExpression.Declarations = declarations.ToList();
                simpleNameExpression.Type = GetType(simpleNameExpression.Declarations);

                if (declarations.Count == 1 && declarations[0] is GetterSetterDeclaration getterSetterDeclaration)
                {
                    if (simpleNameExpression.Parent is AssignmentExpression assignmentExpression && simpleNameExpression == assignmentExpression.Left)
                    {
                        if (getterSetterDeclaration.Setter == null)
                            Errors.Add(new CompilationError(simpleNameExpression.Context, $"{getterSetterDeclaration.Name} has no setter."));
                        else
                            simpleNameExpression.Declarations = new List<INamedDeclaration> { getterSetterDeclaration.Setter };
                        if (assignmentExpression.Operator.Value != "=" && getterSetterDeclaration.Getter == null)
                            Errors.Add(new CompilationError(simpleNameExpression.Context, $"{getterSetterDeclaration.Name} has no getter."));
                    }
                    else
                    {
                        if (getterSetterDeclaration.Getter == null)
                            Errors.Add(new CompilationError(simpleNameExpression.Context, $"{getterSetterDeclaration.Name} has no getter."));
                        else
                            simpleNameExpression.Declarations = new List<INamedDeclaration> { getterSetterDeclaration.Getter };
                    }
                }
                return;
            }
            throw new CompilationError(simpleNameExpression.Context, $"Found no declarations matching '{simpleNameExpression.Name}'");
        }

        private static List<INamedDeclaration> GetMatchingDeclarations(INode ancestor, INode source, string name, bool checkVisibility)
        {
            var matchingDeclarations = new List<INamedDeclaration>();

            if (ancestor is ClassDeclaration classDeclaration)
            {
                matchingDeclarations.AddRange(classDeclaration.GettersAndSetters.Where(x => x.Name == name));
                matchingDeclarations.AddRange(classDeclaration.MethodDeclarations.Where(x => x.Name == name));
                matchingDeclarations.AddRange(classDeclaration.Variables.Where(x => x.Name == name));
            }
            else if (ancestor is IHasVariables variableContainer)
            {
                matchingDeclarations.AddRange(variableContainer.Variables.Where(x => x.Name == name));
            }

            if (ancestor is AbstractTopLevelNode topLevelNode)
            {
                matchingDeclarations.AddRange(topLevelNode.ModuleDeclarations.Where(x => x.Name == name));
                matchingDeclarations.AddRange(topLevelNode.ClassDeclarations.Where(x => x.Name == name).DistinctBy(x => x.Name));
                matchingDeclarations.AddRange(topLevelNode.EnumDeclarations.Where(x => x.Name == name));
                matchingDeclarations.AddRange(topLevelNode.MethodDeclarations.Where(x => x.Name == name));
            }

            if (ancestor is SourceFile sourceFile)
            {
                foreach (var importedSourceFile in sourceFile.ImportedSourceFiles)
                {
                    matchingDeclarations.AddRange(importedSourceFile.ImportedModules.Where(x => x.Name == name));
                    matchingDeclarations.AddRange(importedSourceFile.ImportedClasses.Where(x => x.Name == name).DistinctBy(x => x.Name));
                    matchingDeclarations.AddRange(importedSourceFile.ImportedEnums.Where(x => x.Name == name));
                    matchingDeclarations.AddRange(importedSourceFile.ImportedMethods.Where(x => x.Name == name));
                }
            }

            if (ancestor is Root root)
            {
                matchingDeclarations.AddRange(root.NativeModules.Where(x => x.Name == name));
                matchingDeclarations.AddRange(root.NativeMethods.Where(x => x.Name == name));
            }

            return matchingDeclarations;
        }

        private static bool IsStatic(INamedDeclaration declaration)
        {
            switch (declaration)
            {
                case VariableDeclaration variableDeclaration:
                    return variableDeclaration.Modifiers.Contains(MemberModifier.Static);
                case GetterSetterDeclaration getterSetterDeclaration:
                    if (getterSetterDeclaration.Getter != null)
                        return getterSetterDeclaration.Getter.Modifiers.Contains(MemberModifier.Static);
                    return getterSetterDeclaration.Setter.Modifiers.Contains(MemberModifier.Static);
                case MethodDeclaration methodDeclaration:
                    return methodDeclaration.Modifiers.Contains(MemberModifier.Static);
                case ModuleDeclaration _:
                case ClassDeclaration _:
                case EnumDeclaration _:
                case EnumValue _:
                    return true;
                default:
                    throw new Exception("Unexpected declaration: " + declaration?.GetType().FullName);
            }
        }

        private IType GetType(List<INamedDeclaration> declarations)
        {
            if (declarations.All(x => x is ITypeDeclaration))
                return new StaticReference(declarations.Cast<INode>().ToList());

            IType type = null;
            switch (declarations.Single())
            {
                case VariableDeclaration variableDeclaration:
                    type = variableDeclaration.Type;
                    break;
                case GetterSetterDeclaration getterSetterDeclaration:
                    if (getterSetterDeclaration.Getter != null && getterSetterDeclaration.Getter.ReturnType == null)
                        Visit(getterSetterDeclaration.Getter);
                    type = getterSetterDeclaration.Type;
                    break;
                case MethodDeclaration methodDeclaration:
                    type = new MethodReferenceType(methodDeclaration);
                    break;
                default:
                    throw new Exception("Unexpected declaration: " + declarations.Single().GetType().FullName);
            }

            return type;
        }
        
        public override void ExitMemberExpression(MemberExpression memberExpression)
        {
            ExitMemberExpression(memberExpression, memberExpression.Base.Type);
        }
        public void ExitMemberExpression(MemberExpression memberExpression, IType baseType)
        {
            if (memberExpression.Declarations.Any())
                return;
            switch (baseType.Unwrap())
            {
                case StaticReference staticReference:
                    var matchingEnumValues = staticReference.Declarations.OfType<EnumDeclaration>().SelectMany(x => x.Values).Where(x => x.Name == memberExpression.Name);
                    var matchingDeclarations = staticReference.Declarations.NotOfType(typeof(EnumDeclaration))
                        .SelectMany(x => GetMatchingDeclarations(x, memberExpression, memberExpression.Name, true))
                        .Concat(matchingEnumValues)
                        .ToList();

                    if (!matchingDeclarations.Any())
                        throw new CompilationError(memberExpression.Context, $"Found no declarations on {memberExpression.Base.Type} matching {memberExpression.Name}");

                    matchingDeclarations = matchingDeclarations.Where(IsStatic).ToList();
                    if (!matchingDeclarations.Any())
                        throw new CompilationError(memberExpression.Context, $"{memberExpression.Name} on {memberExpression.Base.Type} is not static.");

                    if (matchingDeclarations.Count > 1 &&
                        matchingDeclarations.NotOfType(typeof(ITypeDeclaration)).Any())
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found multiple declarations on {memberExpression.Base.Type} matching {memberExpression.Name}"));


                    if (matchingDeclarations.Count == 1 && matchingDeclarations[0] is EnumValue enumValue)
                    {
                        var enumDeclaration = enumValue.Parent;
                        memberExpression.Declarations = new List<INamedDeclaration> { enumValue };
                        memberExpression.Type = new ReferenceType(memberExpression.Context, enumDeclaration);
                        return;
                    }
                    memberExpression.Type = GetType(matchingDeclarations);
                    memberExpression.Declarations = matchingDeclarations;
                    break;
                case GenericType genericType:
                    ExitMemberExpression(memberExpression, genericType.Base);
                    return;
                case ReferenceType referenceType:
                    if (referenceType.Declaration is EnumDeclaration)
                        throw new CompilationError(memberExpression.Context, $"Found no declarations on {memberExpression.Base.Type} matching {memberExpression.Name}");
                    matchingDeclarations = GetMatchingDeclarations(referenceType.Declaration, memberExpression, memberExpression.Name, false);
                    if (matchingDeclarations.Count > 1)
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found multiple declarations on {memberExpression.Base.Type} matching {memberExpression.Name}"));
                    if (matchingDeclarations.Count == 0)
                    {
                        throw new CompilationError(memberExpression.Context, $"Found no declarations on {memberExpression.Base.Type} matching {memberExpression.Name}");
                    }
                    if (IsStatic(matchingDeclarations[0]))
                        Errors.Add(new CompilationError(memberExpression.Context, "Static declaration referenced in non-static context."));

                    memberExpression.Type = ReplaceGenerics(memberExpression, GetType(matchingDeclarations).Wrap(memberExpression.Context));
                    memberExpression.Declarations = matchingDeclarations;
                    break;
                default:
                    throw new CompilationError(memberExpression.Context, $"Found no declarations on {memberExpression.Base.Type} matching {memberExpression.Name}");
            }

            if (memberExpression.Declarations.Count == 1 && memberExpression.Declarations[0] is GetterSetterDeclaration getterSetterDeclaration)
            {
                if (memberExpression.Parent is AssignmentExpression assignmentExpression && memberExpression == assignmentExpression.Left)
                {
                    if (getterSetterDeclaration.Setter == null)
                        Errors.Add(new CompilationError(memberExpression.Context, $"{getterSetterDeclaration.Name} has no setter."));
                    else
                        memberExpression.Declarations = new List<INamedDeclaration> { getterSetterDeclaration.Setter };
                    if (assignmentExpression.Operator.Value != "=" && getterSetterDeclaration.Getter == null)
                        Errors.Add(new CompilationError(memberExpression.Context, $"{getterSetterDeclaration.Name} has no getter."));
                }
                else
                {
                    if (getterSetterDeclaration.Getter == null)
                        Errors.Add(new CompilationError(memberExpression.Context, $"{getterSetterDeclaration.Name} has no getter."));
                    else
                        memberExpression.Declarations = new List<INamedDeclaration> { getterSetterDeclaration.Getter };
                }
            }
        }
    }
}