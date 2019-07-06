using System;
using System.Collections.Generic;
using System.Linq;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.types;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class TypeLinker : TreeVoidWalker
    {
        public override void ExitReferenceType(ReferenceType referenceType)
        {
            var names = referenceType.Identifiers.Select(x => x.Text).ToList();

            var matchingGenerics = GetMatchingGenerics(referenceType);
            if (matchingGenerics.Count > 1)
            {
                Errors.Add(new CompilationError(referenceType.Context, $"Found multiple generics matching {names[0]}"));
                return;
            }

            if (matchingGenerics.Count == 1)
            {
                referenceType.Declaration = matchingGenerics[0];
                return;
            }

            var matchingClassesAndEnums = GetMatchingClassesAndEnums(referenceType);
            if (matchingClassesAndEnums.Count > 1)
                Errors.Add(new CompilationError(referenceType.Context, $"Found multiple classes/enums matching {names.MkString(".")}"));
            if (matchingClassesAndEnums.Count == 0)
            {
                Errors.Add(new CompilationError(referenceType.Context, $"Found no classes/enums matching '{names.MkString(".")}'."));
                return;
            }
            if (matchingClassesAndEnums[0] is ClassDeclaration classDeclaration)
                referenceType.Declaration = classDeclaration;
            if (matchingClassesAndEnums[0] is EnumDeclaration enumDeclaration)
                referenceType.Declaration = enumDeclaration;
        }

        private List<GenericTypeDeclaration> GetMatchingGenerics(ReferenceType referenceType)
        {
            if (referenceType.Identifiers.Count() != 1)
                return new List<GenericTypeDeclaration>();
            var parentMethod = referenceType.NearestAncestorOfType<MethodDeclaration>();

            var methodGenerics = parentMethod?.GenericTypeDeclarations.Where(x => x.Name == referenceType.Identifiers.First().Text).ToList() ?? new List<GenericTypeDeclaration>();
            if (methodGenerics.Any())
                return methodGenerics;
            var parentClass = referenceType.NearestAncestorOfType<ClassDeclaration>();
            if (parentClass == null || IsStatic(referenceType))
                return new List<GenericTypeDeclaration>();

            var classGenerics = parentClass?.GenericTypeDeclarations.Where(x => x.Name == referenceType.Identifiers.First().Text).ToList() ?? new List<GenericTypeDeclaration>();

            return classGenerics;
        }

        private bool IsStatic(INode node)
        {
            var parentDeclaration = node.NearestAncestorOfAnyType(typeof(MethodDeclaration), typeof(GetterDeclaration),
                typeof(SetterDeclaration));
            if (parentDeclaration == null)
                return node.NearestAncestorOfType<VariableDeclaration>().Modifiers.Contains(MemberModifier.Static);
            switch (parentDeclaration)
            {
                case MethodDeclaration methodDeclaration:
                    return methodDeclaration.Modifiers.Contains(MemberModifier.Static);
                case GetterDeclaration getterDeclaration:
                    return getterDeclaration.Modifiers.Contains(MemberModifier.Static);
                case SetterDeclaration setterDeclaration:
                    return setterDeclaration.Modifiers.Contains(MemberModifier.Static);
            }
            throw new Exception("Unreachable");
        }

        private List<INode> GetMatchingClassesAndEnums(ReferenceType referenceType)
        {
            var names = referenceType.Identifiers.Select(x => x.Text).ToList();
            var ancestors = referenceType.AllAncestorOfType<AbstractTopLevelNode>();
            foreach (var ancestor in ancestors)
            {
                var nodes = new List<AbstractTopLevelNode> { ancestor };
                for (int i = 0; i < referenceType.Identifiers.Count(); i++)
                {
                    if (i < referenceType.Identifiers.Count() - 1)
                    {
                        nodes = nodes
                            .SelectMany(x => x.ModuleDeclarations.Where(y => y.Name == referenceType.Identifiers.AtIndex(i).Text))
                            .Cast<AbstractTopLevelNode>()
                            .ToList();
                    }
                    else
                    {
                        var matchingClasses = nodes.SelectMany(x => x.ClassDeclarations.Where(y => y.Name == names[i])).DistinctBy(x => x.Name).ToList();
                        var matchingEnums = nodes.SelectMany(x => x.EnumDeclarations.Where(y => y.Name == names[i])).ToList();

                        if (matchingClasses.Count + matchingEnums.Count > 0)
                            return matchingClasses.Concat<INode>(matchingEnums).ToList();
                    }
                }
            }
            return new List<INode>();
        }

        public override void ExitClassDeclaration(ClassDeclaration classDeclaration)
        {
            foreach (var getterSetterDeclaration in classDeclaration.GettersAndSetters)
            {
                if (getterSetterDeclaration.Getter != null
                    && getterSetterDeclaration.Setter != null
                    && getterSetterDeclaration.Getter.ReturnType != getterSetterDeclaration.Setter.Parameter.Type)
                    Errors.Add(new CompilationError(getterSetterDeclaration.Getter.Context, "Getters and setters of the same name must have the same type."));
            }
        }
    }
}