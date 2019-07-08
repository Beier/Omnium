using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.types
{
    public class ArrayType : Node, ITypeNode
    {
        public ITypeNode Base => Children.OfType<ITypeNode>().SingleOrDefault();

        public ArrayType(IParseTree context, ITypeNode @base) : base(context, @base.Yield())
        {
        }

        public override string ToString()
        {
            return Base + "[]";
        }
    }
}