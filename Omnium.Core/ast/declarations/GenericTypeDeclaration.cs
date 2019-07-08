using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.declarations
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