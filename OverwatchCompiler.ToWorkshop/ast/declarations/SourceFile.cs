using System.Collections.Generic;
using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class SourceFile : AbstractTopLevelNode
    {
        public string FileName => System.IO.Path.GetFileName(Path);
        public string Path { get; set; }
        public readonly List<SourceFile> ImportedSourceFiles = new List<SourceFile>();

        public SourceFile(IParseTree context, string path, IEnumerable<INode> children) : base(context, children)
        {
            Path = path;
        }
    }
}