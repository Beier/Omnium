using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class CastExpression : Expression
    {
        public readonly ChildProperty<IExpression> Base;
        public readonly ChildProperty<ITypeNode> TargetType;

        public CastExpression(IParseTree context, IExpression @base, ITypeNode targetType) : base(context)
        {
            Base = new ChildProperty<IExpression>(this, @base);
            TargetType = new ChildProperty<ITypeNode>(this, targetType);
        }
    }
}