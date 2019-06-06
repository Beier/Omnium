using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast2.declarations
{
    public class GenericTypeDeclaration : Node
    {
        public string Name { get; set; }

        public GenericTypeDeclaration(IParseTree context, string name) : base(context)
        {
            Name = name;
        }
    }
}