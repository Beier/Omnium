using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class ArrayIndexExpression: Expression
    {
        public readonly ChildProperty<IExpression> Array;
        public readonly ChildProperty<IExpression> Index;

        public ArrayIndexExpression(IParseTree context, IExpression array, IExpression index) : base(context)
        {
            Array = new ChildProperty<IExpression>(this, array);
            Index = new ChildProperty<IExpression>(this, index);
        }
    }
}