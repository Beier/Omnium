using System.Collections.Generic;
using System.Linq;
using Omnium.Core.ast.declarations;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler
{
    public class ClassMerger : TreeVoidWalker
    {
        private readonly List<string> currentPath = new List<string>();
        private readonly Dictionary<string, List<ClassDeclaration>> equivalentClassDeclarations = new Dictionary<string, List<ClassDeclaration>>();

        public override void EnterModuleDeclaration(ModuleDeclaration moduleDeclaration)
        {
            currentPath.Add(moduleDeclaration.Name);
        }

        public override void ExitModuleDeclaration(ModuleDeclaration moduleDeclaration)
        {
            currentPath.RemoveAt(currentPath.Count - 1);
        }

        public override void ExitClassDeclaration(ClassDeclaration classDeclaration)
        {
            var fullName = currentPath.Concat(classDeclaration.Name.Yield()).MkString(".");
            if (!equivalentClassDeclarations.TryGetValue(fullName, out var list))
            {
                list = new List<ClassDeclaration>();
                equivalentClassDeclarations.Add(fullName, list);
            }
            list.Add(classDeclaration);
        }

        public override void ExitRoot(Root root)
        {
            foreach (var list in equivalentClassDeclarations.Values)
            {
                foreach (var classDeclaration in list)
                {
                    classDeclaration.EquivalentClassDeclarations.AddRange(list);
                }
            }
        }
    }
}