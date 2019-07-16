using System.Linq;
using Omnium.Core.ast.declarations;

namespace Omnium.Core.compiler.step1Parsing
{
    public class ImportLinker : TreeVoidWalker
    {
        public override void EnterSourceFile(SourceFile sourceFile)
        {
            foreach (var importDeclaration in sourceFile.ImportedSourceFiles)
            {
                foreach (var identifier in importDeclaration.ImportedNames)
                {
                    var name = identifier.Text;
                    var matchingClasses = importDeclaration.TargetSourceFile.ClassDeclarations.Where(x => x.Name == name && x.Modifiers.Contains(MemberModifier.Export)).ToList();
                    var matchingModules = importDeclaration.TargetSourceFile.ModuleDeclarations.Where(x => x.Name == name && x.Modifiers.Contains(MemberModifier.Export)).ToList();
                    var matchingMethods = importDeclaration.TargetSourceFile.MethodDeclarations.Where(x => x.Name == name && x.Modifiers.Contains(MemberModifier.Export)).ToList();
                    var matchingEnums = importDeclaration.TargetSourceFile.EnumDeclarations.Where(x => x.Name == name && x.Modifiers.Contains(MemberModifier.Export)).ToList();

                    if (matchingClasses.Count + matchingModules.Count + matchingMethods.Count + matchingEnums.Count == 0)
                        Errors.Add(new CompilationError(identifier.Context, $"Found no exported declaration in {importDeclaration.TargetSourceFile.FileName} matching {name}."));
                    
                    importDeclaration.ImportedClasses.AddRange(matchingClasses);
                    importDeclaration.ImportedModules.AddRange(matchingModules);
                    importDeclaration.ImportedMethods.AddRange(matchingMethods);
                    importDeclaration.ImportedEnums.AddRange(matchingEnums);
                }
            }
            skipChildren = true;
        }
    }
}