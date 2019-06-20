using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class BinaryExpression: Expression
    {
        public readonly ChildProperty<IExpression> Left;
        public readonly ChildProperty<Token> Operator;
        public readonly ChildProperty<IExpression> Right;

        public BinaryExpression(IParseTree context, IExpression left, Token @operator, IExpression right) : base(context)
        {
            Left = new ChildProperty<IExpression>(this, left);
            Operator = new ChildProperty<Token>(this, @operator);
            Right = new ChildProperty<IExpression>(this, right);
        }
    }
}