using System.Collections.Generic;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class Root : Node
    {
        public Root() : base(null)
        {
            SourceFiles = new ChildList<SourceFile>(this);
            NativeMethods = new ChildList<NativeMethodDeclaration>(this);
        }

        public ChildList<SourceFile> SourceFiles { get; }
        public ChildList<NativeMethodDeclaration> NativeMethods { get; }
    }
}