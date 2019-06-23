using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;

namespace OverwatchCompiler.ToWorkshop.ast.statements
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