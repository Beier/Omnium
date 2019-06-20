using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class SwitchStatement : Node, IStatement
    {
        public readonly ChildProperty<IExpression> Expression;
        public readonly ChildList<SwitchGroup> Groups;

        public SwitchStatement(IParseTree context, IExpression expression, IEnumerable<SwitchGroup> groups) : base(context)
        {
            Expression = new ChildProperty<IExpression>(this, expression);
            Groups = new ChildList<SwitchGroup>(this);
            Groups.AddRange(groups);
        }
    }

    public class SwitchGroup : Node
    {
        public readonly ChildList<SwitchLabel> Labels;
        public readonly ChildList<IStatement> Statements;

        public SwitchGroup(IParseTree context, IEnumerable<SwitchLabel> labels, IEnumerable<IStatement> statements) : base(context)
        {
            Labels = new ChildList<SwitchLabel>(this);
            Labels.AddRange(labels);
            Statements = new ChildList<IStatement>(this);
            Statements.AddRange(statements);
        }
    }

    public class SwitchLabel : Node
    {
        public readonly ChildProperty<IExpression> condition;

        public SwitchLabel(IParseTree context, IExpression condition) : base(context)
        {
            this.condition = new ChildProperty<IExpression>(this, condition);
        }
    }
}
