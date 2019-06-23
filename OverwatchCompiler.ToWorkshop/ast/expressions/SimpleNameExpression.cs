using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class SimpleNameExpression : Expression
    {
        public string Name { get; set; }
        public INamedDeclaration Declaration { get; set; }

        public SimpleNameExpression(IParseTree context, string name) : base(context)
        {
            Name = name;
        }

        public override string ToString()
        {
            return Name;
        }
    }
}