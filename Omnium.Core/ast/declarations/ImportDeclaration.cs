using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.declarations
{
    public class ImportDeclaration : Node
    {
        public IEnumerable<Token> ImportedNames => Children.Cast<Token>();
        public SourceFile TargetSourceFile { get; set; }
        public List<ClassDeclaration> ImportedClasses = new List<ClassDeclaration>();
        public List<ModuleDeclaration> ImportedModules = new List<ModuleDeclaration>();
        public List<MethodDeclaration> ImportedMethods = new List<MethodDeclaration>();
        public List<EnumDeclaration> ImportedEnums = new List<EnumDeclaration>();

        public ImportDeclaration(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}