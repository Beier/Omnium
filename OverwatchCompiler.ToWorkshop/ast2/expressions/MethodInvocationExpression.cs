using System.Collections.Generic;
using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast2.expressions
{
    public class MethodInvocationExpression : Node, IExpression
    {
        public readonly ChildProperty<IExpression> Base;
        public readonly ChildList<IExpression> Arguments;

        public MethodInvocationExpression(IParseTree context, IExpression @base, IEnumerable<IExpression> arguments) : base(context)
        {
            Base = new ChildProperty<IExpression>(this, @base);
            Arguments = new ChildList<IExpression>(this);
            Arguments.AddRange(arguments);
        }
    }
}