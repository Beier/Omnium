using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.expressions;

namespace Omnium.Core.ast.statements
{
    public class WhileStatement : Node, IStatement
    {
        public IExpression Condition => Children.OfType<IExpression>().SingleOrDefault();
        public IStatement Body => Children.OfType<IStatement>().SingleOrDefault();

        public WhileStatement(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}