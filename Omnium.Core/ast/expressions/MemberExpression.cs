using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.declarations;

namespace Omnium.Core.ast.expressions
{
    public class MemberExpression : Expression, INameExpression
    {
        public IExpression Base => Children.OfType<IExpression>().SingleOrDefault();
        public string Name { get; }

        public INamedDeclaration Declaration
        {
            get => Declarations.Single();
            set => Declarations = new List<INamedDeclaration> { value };
        }
        public List<INamedDeclaration> Declarations { get; set; } = new List<INamedDeclaration>();

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