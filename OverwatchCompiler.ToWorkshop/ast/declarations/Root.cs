using System.Collections.Generic;
using System.Linq;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class Root : Node
    {
        public Root(IEnumerable<INode> children) : base(null, children)
        {
        }

        public IEnumerable<SourceFile> SourceFiles => Children.OfType<SourceFile>();
        public IEnumerable<ModuleDeclaration> NativeModules => Children.OfType<ModuleDeclaration>();
        public IEnumerable<MethodDeclaration> NativeMethods => Children.OfType<MethodDeclaration>();
        public IEnumerable<VariableDeclaration> PlayerVariableDeclarations => Children.OfType<VariableDeclaration>();
        public RuleDeclaration GlobalVariableInitializer => Children.OfType<RuleDeclaration>().FirstOrDefault();
        public RuleDeclaration PlayerVariableInitializer => Children.OfType<RuleDeclaration>().LastOrDefault();
        public ModuleDeclaration NativeModule { get; set; }
        public readonly List<string> NativeStrings = new List<string>();
    }
}