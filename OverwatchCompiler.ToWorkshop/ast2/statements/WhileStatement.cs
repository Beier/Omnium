using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2.expressions;

namespace OverwatchCompiler.ToWorkshop.ast2.statements
{
    public class WhileStatement : Node, IStatement
    {
        public readonly ChildProperty<IExpression> Condition;
        public readonly ChildProperty<IStatement> Body;

        public WhileStatement(IParseTree context, IExpression condition, IStatement body) : base(context)
        {
            Condition = new ChildProperty<IExpression>(this, condition);
            Body = new ChildProperty<IStatement>(this, body);
        }
    }
}