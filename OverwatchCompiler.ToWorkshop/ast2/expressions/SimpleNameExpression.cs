using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast2.expressions
{
    public class SimpleNameExpression : Node, IExpression
    {
        public string Name { get; set; }

        public SimpleNameExpression(IParseTree context, string name) : base(context)
        {
            Name = name;
        }
    }
}