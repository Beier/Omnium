using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.expressions;

namespace Omnium.Core.ast.statements
{
    public class SwitchStatement : Node, IStatement
    {
        public IExpression Expression => Children.OfType<IExpression>().SingleOrDefault();
        public IEnumerable<SwitchGroup> Groups => Children.OfType<SwitchGroup>();

        public SwitchStatement(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }

    public class SwitchGroup : Node
    {
        public IEnumerable<SwitchLabel> Labels => Children.OfType<SwitchLabel>();
        public IEnumerable<IStatement> Statements => Children.OfType<IStatement>();

        public SwitchGroup(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }

    public class SwitchLabel : Node
    {
        public IExpression condition => Children.OfType<IExpression>().SingleOrDefault();

        public SwitchLabel(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}
