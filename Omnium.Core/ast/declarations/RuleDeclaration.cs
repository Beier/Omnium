using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.expressions;

namespace Omnium.Core.ast.declarations
{
    public class RuleDeclaration : Node, INamedDeclaration
    {
        public string Name { get; }
        public IExpression Trigger => Children.OfType<IExpression>().First();
        public IExpression Condition => Children.OfType<IExpression>().Skip(1).First();
        public LambdaExpression Action =>(LambdaExpression)Children.OfType<IExpression>().Last();
        public IEnumerable<VariableDeclaration> GlobalVariables => Children.OfType<VariableDeclaration>();
        public int NumberOfStates { get; set; }

        public RuleDeclaration(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }
    }
}