using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2.expressions;

namespace OverwatchCompiler.ToWorkshop.ast2.statements
{
    public class IfStatement : Node, IStatement
    {
        public readonly ChildProperty<IExpression> Condition;
        public readonly ChildProperty<IStatement> TrueBranch;
        public readonly ChildProperty<IStatement> FalseBranch;
        
        public IfStatement(IParseTree context, IExpression condition, IStatement trueBranch, IStatement falseBranch): base(context)
        {
            Condition = new ChildProperty<IExpression>(this, condition);
            TrueBranch = new ChildProperty<IStatement>(this, trueBranch);
            FalseBranch = new ChildProperty<IStatement>(this, falseBranch);
        }
    }
}