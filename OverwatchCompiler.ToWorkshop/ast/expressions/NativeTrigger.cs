using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class NativeTrigger : Expression
    {
        public readonly string Name;
        public IEnumerable<IExpression> Arguments => Children.Cast<IExpression>();

        public NativeTrigger(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }

        public override string ToString()
        {
            if (!Arguments.Any())
                return Name;
            return Name + "(" + Arguments.MkString(", ") + ")";
        }
    }
}