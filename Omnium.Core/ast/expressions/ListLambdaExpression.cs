using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.types;

namespace Omnium.Core.ast.expressions
{
    public class ListLambdaExpression: Expression
    {
        public string Name { get; }
        public IExpression List => Children.OfType<IExpression>().First();
        public LambdaExpression Condition => Children.OfType<LambdaExpression>().SingleOrDefault();
        public ITypeNode ReturnType => Children.OfType<ITypeNode>().SingleOrDefault();

        public ListLambdaExpression(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }

        public override string ToString()
        {
            return $"{List}.filter({Condition})";
        }
    }
}