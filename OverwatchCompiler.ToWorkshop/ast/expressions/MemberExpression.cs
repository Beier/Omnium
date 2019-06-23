using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class MemberExpression : Expression
    {
        public IExpression Base => Children.OfType<IExpression>().SingleOrDefault();
        public string Name { get; }
        public INamedDeclaration Declaration { get; set; }

        public MemberExpression(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }

        public override string ToString()
        {
            return Base + "." + Name;
        }
    }
}