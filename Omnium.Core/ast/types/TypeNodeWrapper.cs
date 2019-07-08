using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.types
{
    public class TypeNodeWrapper : Node, ITypeNode
    {
        public readonly IType Type;

        public TypeNodeWrapper(IParseTree context, IType type) : base(context)
        {
            Type = type;
        }

        public override string ToString()
        {
            return Type.ToString();
        }
    }
}