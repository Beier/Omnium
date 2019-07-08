using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;

namespace Omnium.Core.ast.statements
{
    public class ForeachStatement : Node, IStatement, IHasVariables
    {
        public VariableDeclaration Variable => Variables.SingleOrDefault();
        public IExpression List => Children.OfType<IExpression>().SingleOrDefault();
        public IStatement Body => Children.OfType<IStatement>().SingleOrDefault();


        public ForeachStatement(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        public IEnumerable<VariableDeclaration> Variables => Children.OfType<VariableDeclaration>();
    }
}