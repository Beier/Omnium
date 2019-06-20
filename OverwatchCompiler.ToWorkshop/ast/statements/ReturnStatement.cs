using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class ReturnStatement: Node, IStatement
    {
        public readonly ChildProperty<IExpression> Value;

        public ReturnStatement(IParseTree context, IExpression value) : base(context)
        {
            Value = new ChildProperty<IExpression>(this, value);
        }
    }
}