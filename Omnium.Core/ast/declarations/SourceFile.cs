using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.declarations
{
    public class SourceFile : AbstractTopLevelNode
    {
        public string FileName => System.IO.Path.GetFileName(Path);
        public string Path { get; set; }
        public IEnumerable<ImportDeclaration> ImportedSourceFiles => Children.OfType<ImportDeclaration>();

        public SourceFile(IParseTree context, string path, IEnumerable<INode> children) : base(context, children)
        {
            Path = path;
        }
    }
}