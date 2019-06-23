using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.expressions.literals;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class ConstantEvaluator : TreeVoidWalker
    {
        private bool madeChanges = false;

        private ConstantEvaluator() { }

        public static bool EvaluateConstants(INode node)
        {
            var evaluator = new ConstantEvaluator();
            evaluator.Visit(node);
            return evaluator.madeChanges;
        }

        public override void ExitBinaryExpression(BinaryExpression binaryExpression)
        {
            switch (binaryExpression.Operator.Text)
            {
                case "||":
                case "|":
                {
                    if (binaryExpression.Left is BooleanLiteral left && binaryExpression.Right is BooleanLiteral right)
                    {
                        binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, left.Value || right.Value));
                        madeChanges = true;
                    }
                    break;
                }
                case "&&":
                case "&":
                {
                    if (binaryExpression.Left is BooleanLiteral left && binaryExpression.Right is BooleanLiteral right)
                    {
                        binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, left.Value && right.Value));
                        madeChanges = true;
                    }
                    break;
                }
                case "==":
                {
                    if (binaryExpression.Left is BooleanLiteral leftBoolean && binaryExpression.Right is BooleanLiteral rightBoolean)
                    {
                        binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, leftBoolean.Value == rightBoolean.Value));
                        madeChanges = true;
                    }
                    if (binaryExpression.Left is NumberLiteral leftNumber && binaryExpression.Right is NumberLiteral rightNumber)
                    {
                        binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, leftNumber.Value == rightNumber.Value));
                        madeChanges = true;
                    }
                    if (binaryExpression.Left is MemberExpression leftMember 
                        && binaryExpression.Right is MemberExpression rightMember
                        && leftMember.Declaration is EnumValue leftEnum
                        && rightMember.Declaration is EnumValue rightEnum)
                    {
                        binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, leftEnum == rightEnum));
                        madeChanges = true;
                    }
                    break;
                }
                case "!=":
                {
                    if (binaryExpression.Left is BooleanLiteral leftBoolean && binaryExpression.Right is BooleanLiteral rightBoolean)
                    {
                        binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, leftBoolean.Value != rightBoolean.Value));
                        madeChanges = true;
                    }
                    if (binaryExpression.Left is NumberLiteral leftNumber && binaryExpression.Right is NumberLiteral rightNumber)
                    {
                        binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, leftNumber.Value != rightNumber.Value));
                        madeChanges = true;
                    }
                    break;
                }
                case "<":
                {
                    if (binaryExpression.Left is NumberLiteral leftNumber && binaryExpression.Right is NumberLiteral rightNumber)
                    {
                        binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, leftNumber.Value < rightNumber.Value));
                        madeChanges = true;
                    }
                    break;
                }
                case "<=":
                {
                    if (binaryExpression.Left is NumberLiteral leftNumber && binaryExpression.Right is NumberLiteral rightNumber)
                    {
                        binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, leftNumber.Value <= rightNumber.Value));
                        madeChanges = true;
                    }
                    break;
                }
                case ">":
                {
                    if (binaryExpression.Left is NumberLiteral leftNumber && binaryExpression.Right is NumberLiteral rightNumber)
                    {
                        binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, leftNumber.Value > rightNumber.Value));
                        madeChanges = true;
                    }
                    break;
                }
                case ">=":
                {
                    if (binaryExpression.Left is NumberLiteral leftNumber && binaryExpression.Right is NumberLiteral rightNumber)
                    {
                        binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, leftNumber.Value >= rightNumber.Value));
                        madeChanges = true;
                    }
                    break;
                }
                case "+":
                {
                    if (binaryExpression.Left is NumberLiteral leftNumber && binaryExpression.Right is NumberLiteral rightNumber)
                    {
                        binaryExpression.ReplaceWith(new NumberLiteral(binaryExpression.Context, leftNumber.Value + rightNumber.Value));
                        madeChanges = true;
                    }
                    if (binaryExpression.Left is StringLiteral leftString && binaryExpression.Right is StringLiteral rightString)
                    {
                        binaryExpression.ReplaceWith(new StringLiteral(binaryExpression.Context, "\"" + leftString.UnquotedText + rightString.UnquotedText + "\""));
                        madeChanges = true;
                    }
                    break;
                }
                case "-":
                {
                    if (binaryExpression.Left is NumberLiteral leftNumber && binaryExpression.Right is NumberLiteral rightNumber)
                    {
                        binaryExpression.ReplaceWith(new NumberLiteral(binaryExpression.Context, leftNumber.Value - rightNumber.Value));
                        madeChanges = true;
                    }
                    break;
                }
                case "*":
                {
                    if (binaryExpression.Left is NumberLiteral leftNumber && binaryExpression.Right is NumberLiteral rightNumber)
                    {
                        binaryExpression.ReplaceWith(new NumberLiteral(binaryExpression.Context, leftNumber.Value * rightNumber.Value));
                        madeChanges = true;
                    }
                    break;
                }
                case "/":
                {
                    if (binaryExpression.Left is NumberLiteral leftNumber && binaryExpression.Right is NumberLiteral rightNumber && rightNumber.Value != 0)
                    {
                        binaryExpression.ReplaceWith(new NumberLiteral(binaryExpression.Context, leftNumber.Value / rightNumber.Value));
                        madeChanges = true;
                    }
                    break;
                }
                case "%":
                {
                    if (binaryExpression.Left is NumberLiteral leftNumber && binaryExpression.Right is NumberLiteral rightNumber && rightNumber.Value != 0)
                    {
                        binaryExpression.ReplaceWith(new NumberLiteral(binaryExpression.Context, leftNumber.Value % rightNumber.Value));
                        madeChanges = true;
                    }
                    break;
                }
            }
        }

        public override void ExitUnaryExpression(UnaryExpression unaryExpression)
        {
            switch (unaryExpression.Operator.Text)
            {
                case "-":
                {
                    if (unaryExpression.Base is NumberLiteral number)
                    {
                        unaryExpression.ReplaceWith(new NumberLiteral(unaryExpression.Context, -number.Value));
                        madeChanges = true;
                    }
                    break;
                }
                case "!":
                {
                    if (unaryExpression.Base is BooleanLiteral boolean)
                    {
                        unaryExpression.ReplaceWith(new BooleanLiteral(unaryExpression.Context, !boolean.Value));
                        madeChanges = true;
                    }
                    break;
                }
            }
        }
    }
}