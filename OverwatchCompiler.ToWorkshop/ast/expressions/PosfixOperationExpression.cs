using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class PosfixOperationExpression : Expression
    {
        public readonly ChildProperty<IExpression> Base;
        public readonly ChildProperty<Token> Operation;

        public PosfixOperationExpression(IParseTree context, IExpression @base, Token operation) : base(context)
        {
            Base = new ChildProperty<IExpression>(this, @base);
            Operation = new ChildProperty<Token>(this, operation);
        }
    }
}