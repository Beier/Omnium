using System.Collections.Generic;
using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast2.declarations
{
    public class SourceFile : AbstractTopLevelNode
    {
        public string Path { get; set; }
        public List<SourceFile> ImportedSourceFiles { get; set; }

        public SourceFile(IParseTree context, string path) : base(context)
        {
            Path = path;
        }
    }
}