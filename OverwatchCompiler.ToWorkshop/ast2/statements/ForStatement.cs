using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2.declarations;
using OverwatchCompiler.ToWorkshop.ast2.expressions;

namespace OverwatchCompiler.ToWorkshop.ast2.statements
{
    public class ForStatement : Node, IStatement
    {
        public readonly ChildList<VariableDeclaration> Variables;
        public readonly ChildList<IExpression> InitExpressions;
        public readonly ChildProperty<IExpression> Condition;
        public readonly ChildList<IExpression> NextExpressions;
        public readonly ChildProperty<IStatement> Body;

        public ForStatement(
            IParseTree context, 
            IEnumerable<VariableDeclaration> variables, 
            IEnumerable<IExpression> initExpressions, 
            IExpression condition, 
            IEnumerable<IExpression> nextExpressions, 
            IStatement body) : base(context)
        {
            Variables = new ChildList<VariableDeclaration>(this);
            Variables.AddRange(variables);
            InitExpressions = new ChildList<IExpression>(this);
            InitExpressions.AddRange(initExpressions);
            Condition = new ChildProperty<IExpression>(this, condition);
            NextExpressions = new ChildList<IExpression>(this);
            NextExpressions.AddRange(nextExpressions);
            Body = new ChildProperty<IStatement>(this, body);
        }
    }
}