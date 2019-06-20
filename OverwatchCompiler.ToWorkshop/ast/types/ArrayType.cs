using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class ArrayType : Node, ITypeNode
    {
        public readonly ChildProperty<ITypeNode> Base;

        public ArrayType(IParseTree context, ITypeNode @base) : base(context)
        {
            Base = new ChildProperty<ITypeNode>(this, @base);
        }

        public override string ToString()
        {
            return Base.Value + "[]";
        }
    }
}