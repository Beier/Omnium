using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class MemberExpression : Expression
    {
        public readonly ChildProperty<IExpression> Base;
        public string Name { get; set; }

        public MemberExpression(IParseTree context, IExpression @base, string name) : base(context)
        {
            Base = new ChildProperty<IExpression>(this, @base);
            Name = name;
        }
    }
}