using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class CastExpression : Expression
    {
        public IExpression Base => Children.OfType<IExpression>().SingleOrDefault();
        public ITypeNode TargetType => Children.OfType<ITypeNode>().SingleOrDefault();

        public CastExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}