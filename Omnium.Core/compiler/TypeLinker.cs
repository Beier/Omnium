using System;
using System.Collections.Generic;
using System.Linq;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler
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

            var classGenerics = parentClass.GenericTypeDeclarations.Where(x => x.Name == referenceType.Identifiers.First().Text).ToList() ?? new List<GenericTypeDeclaration>();

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
                            .SelectMany(GetDeclarations)
                            .OfType<ModuleDeclaration>()
                            .Where(x => x.Name == referenceType.Identifiers.AtIndex(i).Text)
                            .Cast<AbstractTopLevelNode>()
                            .ToList();
                    }
                    else
                    {
                        var declarations = nodes.SelectMany(GetDeclarations).ToList();
                        var matchingClasses = declarations.OfType<ClassDeclaration>().Where(x => x.Name == names[i]).DistinctBy(x => x.Name).ToList();
                        var matchingEnums = declarations.OfType<EnumDeclaration>().Where(y => y.Name == names[i]).ToList();

                        if (matchingClasses.Count + matchingEnums.Count > 0)
                            return matchingClasses.Concat<INode>(matchingEnums).ToList();
                    }
                }
            }
            return new List<INode>();
        }

        private IEnumerable<INamedDeclaration> GetDeclarations(AbstractTopLevelNode node)
        {
            var declarations = node.Children.OfType<INamedDeclaration>();
            if (node is SourceFile sourceFile)
            {
                declarations = declarations.Concat(sourceFile.ImportedSourceFiles.SelectMany(
                    x => x.ImportedModules.Concat<INamedDeclaration>(x.ImportedClasses).Concat(x.ImportedEnums)
                ));
            }

            return declarations;
        }
    }
}