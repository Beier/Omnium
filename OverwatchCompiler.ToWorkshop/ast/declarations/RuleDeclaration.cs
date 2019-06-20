using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.expressions;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class RuleDeclaration : Node, INamedDeclaration
    {
        public string Name { get; }
        public readonly ChildProperty<IExpression> Trigger;
        public readonly ChildProperty<IExpression> Condition;
        public readonly ChildProperty<IExpression> Action;

        public RuleDeclaration(IParseTree context, string name, IExpression trigger, IExpression condition, IExpression action) : base(context)
        {
            Name = name;
            Trigger = new ChildProperty<IExpression>(this, trigger);
            Condition = new ChildProperty<IExpression>(this, condition);
            Action = new ChildProperty<IExpression>(this, action);
        }
    }
}