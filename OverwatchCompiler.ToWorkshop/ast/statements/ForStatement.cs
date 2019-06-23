using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class ForStatement : Node, IStatement, IHasVariables
    {
        public IEnumerable<VariableDeclaration> Variables => ChildGroups.First().Cast<VariableDeclaration>();
        public IEnumerable<IExpression> InitExpressions => ChildGroups.Skip(1).First().Cast<IExpression>();
        public IExpression Condition => ChildGroups.Skip(2).First().Cast<IExpression>().SingleOrDefault();
        public IEnumerable<IExpression> NextExpressions => ChildGroups.Skip(3).First().Cast<IExpression>();
        public IStatement Body => ChildGroups.Skip(4).First().Cast<IStatement>().SingleOrDefault();

        public ForStatement(
            IParseTree context, 
            IEnumerable<VariableDeclaration> variableDeclarations, 
            IEnumerable<IExpression> initExpressions, 
            IExpression condition, 
            IEnumerable<IExpression> nextExpressions, 
            IStatement body) : base(context, new IEnumerable<INode>[]
        {
            variableDeclarations,
            initExpressions,
            condition.Yield(),
            nextExpressions,
            body.Yield()
        })
        {
        }
        
    }
}