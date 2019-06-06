using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2.expressions;

namespace OverwatchCompiler.ToWorkshop.ast2.statements
{
    public class ExpressionStatement : Node, IStatement
    {
        public readonly ChildProperty<IExpression> Expression;

        public ExpressionStatement(IParseTree context, IExpression expression) : base(context)
        {
            Expression = new ChildProperty<IExpression>(this, expression);
        }
    }
}