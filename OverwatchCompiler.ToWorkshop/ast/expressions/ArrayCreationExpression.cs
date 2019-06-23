using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class ArrayCreationExpression : Expression
    {
        public IEnumerable<IExpression> InitialItems => Children.OfType<IExpression>();

        public ArrayCreationExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}