using System;
using System.Collections.Generic;
using System.Linq;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler
{
    public class ClassDeleter : TreeVoidWalker
    {
        private readonly Dictionary<GetterDeclaration, MethodDeclaration> replacedGetters = new Dictionary<GetterDeclaration, MethodDeclaration>();
        private readonly Dictionary<SetterDeclaration, MethodDeclaration> replacedSetters = new Dictionary<SetterDeclaration, MethodDeclaration>();

        public override void EnterRoot(Root root)
        {
            //RemoveClassGenerics(root);
            var classDeclarations = GetClassDeclarations(root).ToList();
            foreach (var getterDeclaration in classDeclarations.SelectMany(x => x.Getters).ToList())
            {
                ConvertToMethod(getterDeclaration);
            }
            foreach (var setterDeclaration in classDeclarations.SelectMany(x => x.Setters).ToList())
            {
                ConvertToMethod(setterDeclaration);
            }
            foreach (var fieldDeclaration in classDeclarations.SelectMany(x => x.Variables).ToList())
            {
                MoveOutOfClass(fieldDeclaration);
            }
            foreach (var methodDeclaration in classDeclarations.SelectMany(x => x.MethodDeclarations).ToList())
            {
                MoveOutOfClass(methodDeclaration);
            }
            foreach (var classDeclaration in classDeclarations)
            {
                classDeclaration.Remove();
            }
        }

        private bool IsReferenceToGenericClass(INameExpression nameExpression)
        {
            return nameExpression.Declaration is ClassDeclaration classDeclaration &&
                   classDeclaration.GenericTypeDeclarations.Any();
        }

        //private void RemoveClassGenerics(Root root)
        //{
        //    var replacedClassDeclarations = new Dictionary<ClassDeclaration, List<(List<ITypeNode>, ClassDeclaration)>>();
        //    while (true)
        //    {
        //        var referencesToGenericClasses = root.AllDescendantsAndSelf().OfType<INameExpression>()
        //            .Where(IsReferenceToGenericClass).ToList();
        //        if (referencesToGenericClasses.Count == 0)
        //            break;
        //        foreach (var nameExpression in referencesToGenericClasses)
        //        {
        //            var genericClass = (ClassDeclaration)nameExpression.Declaration;
        //            ClassDeclaration normalizedClass = null;
        //            if (!(nameExpression.Parent is GenericType genericType) || genericType.GenericTypes.Count() != genericClass.GenericTypeDeclarations.Count())
        //            {
        //                Errors.Add(new CompilationError(nameExpression.Context, $"{genericClass.Name} has {genericClass.GenericTypeDeclarations.Count()} generic types."));
        //                continue;
        //            }
        //            if (replacedClassDeclarations.TryGetValue(genericClass, out var replacements))
        //            {
        //                foreach (var (replacedTypes, classDeclaration) in replacements)
        //                {
        //                    if (replacedTypes.Zip(genericType.GenericTypes, (n1, n2) => n1.IsEquivalentTo(n2)).All(x => x))
        //                    {
        //                        normalizedClass = classDeclaration;
        //                        break;
        //                    }
        //                }
        //            }
        //            if (normalizedClass == null)
        //            {
        //                normalizedClass = AstCloner.Clone(genericClass);
        //                foreach (var referenceType in normalizedClass.AllDescendantsAndSelf().OfType<ReferenceType>().ToList())
        //                {
        //                    var index = normalizedClass.GenericTypeDeclarations.IndexOf(referenceType.Declaration);
        //                    if (index == -1)
        //                        continue;
        //                    referenceType.ReplaceWith(AstCloner.Clone(genericType.GenericTypes.ElementAt(index)));
        //                }
        //                normalizedClass.RemoveChildren(normalizedClass.GenericTypeDeclarations);
        //                genericClass.Parent.AddChild(normalizedClass);
        //            }

        //            var nameExpressionClone = AstCloner.Clone(nameExpression);
        //            nameExpressionClone.Declaration = normalizedClass;

        //        }
        //    }

        //    //Todo: validate all generic types are removed
        //    //Todo: remove all generic classes





        //    var classUsages = root.AllDescendantsAndSelf().OfType<INameExpression>().GroupBy(x => x.Declaration)
        //        .ToDictionary(x => x.Key, x => x.ToList());
        //    foreach (var classDeclaration in GetClassDeclarations(root).ToList())
        //    {
        //        if (!classDeclaration.GenericTypeDeclarations.Any())
        //            continue;
        //        if (!classUsages.TryGetValue(classDeclaration, out var usages))
        //            classDeclaration.Remove();
        //        var extractedTypeCombinations = new List<(List<ITypeNode>, ClassDeclaration)>();
        //        foreach (var nameExpression in usages)
        //        {
        //            if (!(nameExpression.Parent is GenericType genericType) || genericType.GenericTypes.Count() != classDeclaration.GenericTypeDeclarations.Count())
        //            {
        //                Errors.Add(new CompilationError(nameExpression.Context, $"{classDeclaration.Name} has {classDeclaration.GenericTypeDeclarations.Count()} generic types."));
        //                continue;
        //            }

        //            ClassDeclaration replacedClassDeclaration = null;
        //            foreach (var (usedTypes, c) in extractedTypeCombinations)
        //            {
        //                if (usedTypes.Zip(genericType.GenericTypes, (n1, n2) => n1.IsEquivalentTo(n2)).All(x => x))
        //                {
        //                    replacedClassDeclaration = c;
        //                    break;
        //                }
        //            }

        //            if (replacedClassDeclaration == null)
        //            {
        //                //Todo: we could
        //                replacedClassDeclaration = AstCloner.Clone(classDeclaration);
        //                foreach (var referenceType in replacedClassDeclaration.AllDescendantsAndSelf().OfType<ReferenceType>().ToList())
        //                {
        //                    var index = replacedClassDeclaration.GenericTypeDeclarations.IndexOf(referenceType.Declaration);
        //                    if (index == -1)
        //                        continue;
        //                    referenceType.ReplaceWith(AstCloner.Clone(genericType.GenericTypes.ElementAt(index)));
        //                }
        //            }

        //        }
        //        var usageTypes = usages.Select(x =>
        //        {
        //        })
        //    }
        //}

        private IEnumerable<ClassDeclaration> GetClassDeclarations(INode node)
        {
            switch (node)
            {
                case Root _:
                case SourceFile _:
                case ModuleDeclaration _:
                    foreach (var child in node.Children)
                    {
                        foreach (var classDeclaration in GetClassDeclarations(child))
                        {
                            yield return classDeclaration;
                        }
                    }
                    break;
                case ClassDeclaration classDeclaration:
                    yield return classDeclaration;
                    break;
            }
        }

        private void ConvertToMethod(GetterDeclaration getterDeclaration)
        {
            var methodDeclaration = new MethodDeclaration(
                getterDeclaration.Context,
                "get" + getterDeclaration.Name[0].ToString().ToUpper() + getterDeclaration.Name.Substring(1),
                getterDeclaration.ReturnType.Yield()
                    .Concat<INode>(getterDeclaration.Body.Yield())
            );
            methodDeclaration.Modifiers.AddRange(getterDeclaration.Modifiers);
            getterDeclaration.ReplaceWith(methodDeclaration);
            replacedGetters.Add(getterDeclaration, methodDeclaration);
        }

        private void ConvertToMethod(SetterDeclaration setterDeclaration)
        {
            var methodDeclaration = new MethodDeclaration(
                setterDeclaration.Context,
                "set" + setterDeclaration.Name[0].ToString().ToUpper() + setterDeclaration.Name.Substring(1),
                new VoidType(setterDeclaration.Context).Yield()
                    .Concat<INode>(setterDeclaration.Parameter.Yield())
                    .Concat(setterDeclaration.Body.Yield())
            );
            methodDeclaration.Modifiers.AddRange(setterDeclaration.Modifiers);
            setterDeclaration.ReplaceWith(methodDeclaration);
            replacedSetters.Add(setterDeclaration, methodDeclaration);
        }

        private void MoveOutOfClass(VariableDeclaration fieldDeclaration)
        {
            var classDeclaration = (ClassDeclaration)fieldDeclaration.Parent;
            if (!fieldDeclaration.Modifiers.Contains(MemberModifier.Static))
            {
                if (classDeclaration.Name == "Player")
                {
                    var root = fieldDeclaration.NearestAncestorOfType<Root>();
                    fieldDeclaration.Remove();
                    root.AddChild(fieldDeclaration);
                }
                else
                    Errors.Add(new CompilationError(fieldDeclaration.Context, "State is only possible for the Player class."));

                return;
            }

            var classDeclarationParent = classDeclaration.Parent;
            fieldDeclaration.Remove();
            classDeclarationParent.AddChildAfter(classDeclaration, fieldDeclaration);
        }

        private void MoveOutOfClass(MethodDeclaration methodDeclaration)
        {
            var classDeclaration = (ClassDeclaration)methodDeclaration.Parent;
            if (!methodDeclaration.Modifiers.Contains(MemberModifier.Static))
            {
                var thisParameter = new VariableDeclaration(
                    methodDeclaration.Context,
                    "this" + new Random().Next(),
                    new ReferenceType(methodDeclaration.Context, methodDeclaration.Parent).Yield()
                    );
                methodDeclaration.AddChildBefore(methodDeclaration.Variables.FirstOrDefault() ?? (INode)methodDeclaration.Body, thisParameter);
                ReplaceThisWithReferencesToVariable(methodDeclaration, thisParameter);
            }
            var classDeclarationParent = classDeclaration.Parent;
            methodDeclaration.Remove();
            classDeclarationParent.AddChildAfter(classDeclaration, methodDeclaration);
        }

        private void ReplaceThisWithReferencesToVariable(INode node, VariableDeclaration variableDeclaration)
        {
            if (node is ThisExpression)
            {
                node.ReplaceWith(
                    new SimpleNameExpression(node.Context, variableDeclaration.Name)
                    {
                        Declaration = variableDeclaration,
                        Type = variableDeclaration.Type
                    });
            }
            else
            {
                foreach (var child in node.Children.ToList())
                {
                    ReplaceThisWithReferencesToVariable(child, variableDeclaration);
                }
            }
        }

        //Update references to non-static methods and getters
        public override void ExitSimpleNameExpression(SimpleNameExpression simpleNameExpression)
        {
            var targetMethod = simpleNameExpression.Declaration is GetterDeclaration getterDeclaration ? replacedGetters[getterDeclaration]
                : simpleNameExpression.Declaration is SetterDeclaration setterDeclaration ? replacedSetters[setterDeclaration]
                : null;
            if (targetMethod == null)
                return;
            var @base = new SimpleNameExpression(simpleNameExpression.Context, targetMethod.Name)
            {
                Declaration = targetMethod,
                Type = new MethodReferenceType(targetMethod)
            };

            ReplaceGetterOrSetter(simpleNameExpression, simpleNameExpression.Declaration, @base);
        }

        public override void ExitMemberExpression(MemberExpression memberExpression)
        {
            var targetMethod = memberExpression.Declaration is GetterDeclaration getterDeclaration ? replacedGetters[getterDeclaration]
                : memberExpression.Declaration is SetterDeclaration setterDeclaration ? replacedSetters[setterDeclaration]
                : null;
            if (targetMethod == null)
                return;
            var @base = new MemberExpression(memberExpression.Context, targetMethod.Name, memberExpression.Base.Yield())
            {
                Declaration = targetMethod,
                Type = new MethodReferenceType(targetMethod)
            };

            ReplaceGetterOrSetter(memberExpression, memberExpression.Declaration, @base);
        }

        private void ReplaceGetterOrSetter(IExpression expression, INamedDeclaration declaration, IExpression @base)
        {
            if (declaration is GetterDeclaration)
            {
                var methodInvocation = new MethodInvocationExpression(expression.Context, @base.Yield());
                expression.ReplaceWith(methodInvocation);
                Visit(methodInvocation);
            }
            else if (declaration is SetterDeclaration)
            {
                var assignment = (AssignmentExpression)expression.Parent;
                var methodInvocation = new MethodInvocationExpression(
                    expression.Context,
                    @base.Yield().Concat<INode>(assignment.Right.Yield())
                );
                assignment.ReplaceWith(methodInvocation);
                Visit(methodInvocation);
            }
        }

        public override void ExitMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression)
        {
            var targetMethod = methodInvocationExpression.Target;
            if (targetMethod.Modifiers.Contains(MemberModifier.Static))
                return;

            SimpleNameExpression methodTarget = null;
            IExpression thisExpression = null;
            switch (methodInvocationExpression.Base)
            {
                case MemberExpression memberExpression:
                    methodTarget = new SimpleNameExpression(memberExpression.Context, memberExpression.Name)
                    {
                        Declaration = targetMethod,
                        Type = new MethodReferenceType(targetMethod)
                    };
                    thisExpression = memberExpression.Base;
                    break;
                case SimpleNameExpression simpleNameExpression:
                    //Will only happen if called from another class member
                    methodTarget = simpleNameExpression;
                    var containingMethod = simpleNameExpression.NearestAncestorOfType<MethodDeclaration>();
                    var thisParameter = containingMethod.Variables.First();
                    thisExpression = new SimpleNameExpression(simpleNameExpression.Context, thisParameter.Name)
                    {
                        Declaration = thisParameter,
                        Type = thisParameter.Type
                    };
                    break;
            }

            methodInvocationExpression.Base.ReplaceWith(methodTarget);
            var addBeforeNode = methodInvocationExpression.Arguments.FirstOrDefault();
            if (addBeforeNode != null)
                methodInvocationExpression.AddChildBefore(addBeforeNode, thisExpression);
            else
                methodInvocationExpression.AddChild(thisExpression);
        }
    }
}