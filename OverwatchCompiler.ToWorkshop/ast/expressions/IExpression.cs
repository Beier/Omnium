using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public interface IExpression : INode
    {
        IType Type { get; set; }
    }

    public abstract class Expression : Node, IExpression
    {
        public IType Type { get; set; }

        protected Expression(IParseTree context) : base(context)
        {
        }
    }
}