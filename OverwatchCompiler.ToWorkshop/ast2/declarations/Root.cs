using System.Collections.Generic;

namespace OverwatchCompiler.ToWorkshop.ast2.declarations
{
    public class Root : Node
    {
        public Root() : base(null)
        {
            SourceFiles = new ChildList<SourceFile>(this);
        }

        public ChildList<SourceFile> SourceFiles { get; }
    }
}