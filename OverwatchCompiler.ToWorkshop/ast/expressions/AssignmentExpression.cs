using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class AssignmentExpression : Expression
    {
        public readonly ChildProperty<IExpression> Left;
        public readonly ChildProperty<AssignmentOperator> Operator;
        public readonly ChildProperty<IExpression> Right;

        public AssignmentExpression(IParseTree context, IExpression left, AssignmentOperator @operator, IExpression right) : base(context)
        {
            Left = new ChildProperty<IExpression>(this, left);
            Operator = new ChildProperty<AssignmentOperator>(this, @operator);
            Right = new ChildProperty<IExpression>(this, right);
        }
    }

    public class AssignmentOperator : Node
    {
        public readonly string Value;

        public AssignmentOperator(IParseTree context, string value) : base(context)
        {
            Value = value;
        }
    }
}