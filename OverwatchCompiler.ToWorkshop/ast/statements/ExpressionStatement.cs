using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;

namespace OverwatchCompiler.ToWorkshop.ast.statements
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