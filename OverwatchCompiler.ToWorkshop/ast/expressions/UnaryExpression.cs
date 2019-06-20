using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class UnaryExpression : Expression
    {
        public readonly ChildProperty<Token> Operator;
        public readonly ChildProperty<IExpression> Base;

        public UnaryExpression(IParseTree context, Token @operator, IExpression @base) : base(context)
        {
            Operator = new ChildProperty<Token>(this, @operator);
            Base = new ChildProperty<IExpression>(this, @base);
        }
    }
}