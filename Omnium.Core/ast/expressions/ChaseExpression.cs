using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.expressions
{
    public class ChaseExpression : Expression
    {
        public INameExpression VariableReference => (INameExpression) Children.First();
        public IExpression Destination => (IExpression) Children.Skip(1).First();
        public IExpression DurationOrRate => (IExpression)Children.Skip(2).First();
        public IExpression Reevaluation => (IExpression)Children.Skip(3).First();
        public bool IsOverTime { get; }

        public ChaseExpression(IParseTree context, bool isOverTime, IEnumerable<INode> children) : base(context, children)
        {
            IsOverTime = isOverTime;
        }
    }

    public class StopChaseExpression : Expression
    {
        public INameExpression VariableReference => (INameExpression) Children.Single();

        public StopChaseExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}