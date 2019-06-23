using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class ArrayIndexExpression: Expression
    {
        public IExpression Array => Children.OfType<IExpression>().First();
        public IExpression Index => Children.OfType<IExpression>().Last();

        public ArrayIndexExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}