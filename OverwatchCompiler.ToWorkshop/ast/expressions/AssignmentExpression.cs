using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class AssignmentExpression : Expression
    {
        public IExpression Left => Children.OfType<IExpression>().First();
        public AssignmentOperator Operator => Children.OfType<AssignmentOperator>().SingleOrDefault();
        public IExpression Right => Children.OfType<IExpression>().Last();

        public AssignmentExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        public override string ToString()
        {
            return Left + " = " + Right;
        }
    }

    public class AssignmentOperator : Token
    {
        public string Value { get; set; }

        public AssignmentOperator(IParseTree context, string value) : base(context)
        {
            Value = value;
        }
    }
}