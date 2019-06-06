using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast2.declarations
{
    public class ModuleDeclaration : AbstractTopLevelNode
    {
        public string Name { get; set; }

        public ModuleDeclaration(IParseTree context, string name) : base(context)
        {
            Name = name;
        }
    }
}