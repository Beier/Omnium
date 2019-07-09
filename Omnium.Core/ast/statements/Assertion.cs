using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;

namespace Omnium.Core.ast.statements
{
    public class Assertion : Node, IStatement
    {
        public IExpression Condition => Children.OfType<IExpression>().First();
        public StringLiteral Message => (StringLiteral)Children.OfType<IExpression>().Skip(1).FirstOrDefault();
        public Assertion(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        public override string ToString()
        {
            return $"Assert({Condition}, {Message})";
        }
    }
}