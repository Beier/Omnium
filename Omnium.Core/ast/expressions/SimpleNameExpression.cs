using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.declarations;

namespace Omnium.Core.ast.expressions
{
    public class SimpleNameExpression : Expression, INameExpression
    {
        public string Name { get; set; }
        public INamedDeclaration Declaration
        {
            get => Declarations.Single();
            set => Declarations = new List<INamedDeclaration> { value };
        }
        public List<INamedDeclaration> Declarations { get; set; } = new List<INamedDeclaration>();

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