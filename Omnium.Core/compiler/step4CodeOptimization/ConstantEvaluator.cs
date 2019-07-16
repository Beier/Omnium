using System.Linq;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler.step4CodeOptimization
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
                        if (binaryExpression.Left is NullLiteral && binaryExpression.Right is NullLiteral)
                        {
                            binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, true));
                            madeChanges = true;
                            break;
                        }
                        if (binaryExpression.Left is NullLiteral || binaryExpression.Right is NullLiteral)
                        {
                            var notNullExpression = binaryExpression.Left is NullLiteral
                                ? binaryExpression.Right
                                : binaryExpression.Left;

                            switch (notNullExpression)
                            {
                                case BooleanLiteral _:
                                case NumberLiteral _:
                                case LambdaExpression _:
                                    binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, false));
                                    madeChanges = true;
                                    break;
                            }
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
                        if (binaryExpression.Left is NullLiteral && binaryExpression.Right is NullLiteral)
                        {
                            binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, false));
                            madeChanges = true;
                            break;
                        }
                        if (binaryExpression.Left is NullLiteral || binaryExpression.Right is NullLiteral)
                        {
                            var notNullExpression = binaryExpression.Left is NullLiteral
                                ? binaryExpression.Right
                                : binaryExpression.Left;

                            switch (notNullExpression)
                            {
                                case BooleanLiteral _:
                                case NumberLiteral _:
                                case LambdaExpression _:
                                    binaryExpression.ReplaceWith(new BooleanLiteral(binaryExpression.Context, true));
                                    madeChanges = true;
                                    break;
                            }
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
                        else if (binaryExpression.Left is NumberLiteral leftNumber2 && leftNumber2.Value == 0 && binaryExpression.Type is NumberType)
                        {
                            binaryExpression.ReplaceWith(binaryExpression.Right);
                            madeChanges = true;
                        }
                        else if (binaryExpression.Right is NumberLiteral rightNumber2 && rightNumber2.Value == 0 && binaryExpression.Type is NumberType)
                        {
                            binaryExpression.ReplaceWith(binaryExpression.Left);
                            madeChanges = true;
                        }
                        if (binaryExpression.Left is StringLiteral leftString && binaryExpression.Right is StringLiteral rightString)
                        {
                            binaryExpression.ReplaceWith(new StringLiteral(binaryExpression.Context, "\"" + leftString.UnquotedText + rightString.UnquotedText + "\""));
                            madeChanges = true;
                        }
                        //x + "" => x
                        else if (binaryExpression.Left is StringLiteral leftString2 && leftString2.UnquotedText == "")
                        {
                            binaryExpression.ReplaceWith(binaryExpression.Right);
                            madeChanges = true;
                        }
                        else if (binaryExpression.Right is StringLiteral rightString2 && rightString2.UnquotedText == "")
                        {
                            binaryExpression.ReplaceWith(binaryExpression.Left);
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
                        else if (binaryExpression.Left is NumberLiteral leftNumber2 && leftNumber2.Value == 0)
                        {
                            binaryExpression.ReplaceWith(binaryExpression.Right);
                            madeChanges = true;
                        }
                        else if (binaryExpression.Right is NumberLiteral rightNumber2 && rightNumber2.Value == 0)
                        {
                            binaryExpression.ReplaceWith(binaryExpression.Left);
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
                        else if (binaryExpression.Left is NumberLiteral leftNumber2 && leftNumber2.Value == 1)
                        {
                            binaryExpression.ReplaceWith(binaryExpression.Right);
                            madeChanges = true;
                        }
                        else if (binaryExpression.Right is NumberLiteral rightNumber2 && rightNumber2.Value == 1)
                        {
                            binaryExpression.ReplaceWith(binaryExpression.Left);
                            madeChanges = true;
                        }
                        else if (binaryExpression.Left is NumberLiteral leftNumber3 && leftNumber3.Value == 0)
                        {
                            binaryExpression.ReplaceWith(binaryExpression.Left);
                            madeChanges = true;
                        }
                        else if (binaryExpression.Right is NumberLiteral rightNumber3 && rightNumber3.Value == 0)
                        {
                            binaryExpression.ReplaceWith(binaryExpression.Right);
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
                        else if (binaryExpression.Right is NumberLiteral rightNumber2 && rightNumber2.Value == 1)
                        {
                            binaryExpression.ReplaceWith(binaryExpression.Left);
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
                        switch (unaryExpression.Base)
                        {
                            case BooleanLiteral boolean:
                                unaryExpression.ReplaceWith(new BooleanLiteral(unaryExpression.Context, !boolean.Value));
                                madeChanges = true;
                                break;
                            case UnaryExpression subUnaryExpression:
                                if (subUnaryExpression.Operator.Text == "!")
                                {
                                    unaryExpression.ReplaceWith(subUnaryExpression.Base);
                                    madeChanges = true;
                                }
                                break;
                            case BinaryExpression binaryExpression:
                                var oppositeOperators = new[]
                                {
                                    new[] {"<", ">="},
                                    new[] {">", "<="},
                                    new[] {"==", "!="},
                                    new[] {"&&", "||"}
                                };
                                var currentOperator = binaryExpression.Operator.Text;
                                var newOperator = oppositeOperators.FirstOrDefault(x => x.Contains(currentOperator))?.Except(currentOperator.Yield()).Single();
                                if (newOperator != null)
                                {
                                    binaryExpression.Operator.ReplaceWith(new Token(binaryExpression.Operator.Context, newOperator));
                                    unaryExpression.ReplaceWith(binaryExpression);
                                    if (currentOperator == "&&" || currentOperator == "||")
                                    {
                                        Negate(binaryExpression.Left);
                                        Negate(binaryExpression.Right);
                                    }
                                    madeChanges = true;
                                }
                                break;
                        }
                        break;
                    }
            }
        }

        private void Negate(IExpression expression)
        {
            var negationExpression = new UnaryExpression(expression.Context, new []{new Token(expression.Context, "!")});
            expression.ReplaceWith(negationExpression);
            negationExpression.AddChild(expression);
        }
    }
}