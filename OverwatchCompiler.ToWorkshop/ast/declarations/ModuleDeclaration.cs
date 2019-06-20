using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class ModuleDeclaration : AbstractTopLevelNode, INamedDeclaration
    {
        public string Name { get; set; }

        public ModuleDeclaration(IParseTree context, string name) : base(context)
        {
            Name = name;
        }
    }
}