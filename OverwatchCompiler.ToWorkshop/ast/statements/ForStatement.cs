using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class ForStatement : Node, IStatement, IHasVariables
    {
        public readonly ChildList<VariableDeclaration> VariableDeclarations;
        public readonly ChildList<IExpression> InitExpressions;
        public readonly ChildProperty<IExpression> Condition;
        public readonly ChildList<IExpression> NextExpressions;
        public readonly ChildProperty<IStatement> Body;

        public ForStatement(
            IParseTree context, 
            IEnumerable<VariableDeclaration> variableDeclarations, 
            IEnumerable<IExpression> initExpressions, 
            IExpression condition, 
            IEnumerable<IExpression> nextExpressions, 
            IStatement body) : base(context)
        {
            VariableDeclarations = new ChildList<VariableDeclaration>(this);
            VariableDeclarations.AddRange(variableDeclarations);
            InitExpressions = new ChildList<IExpression>(this);
            InitExpressions.AddRange(initExpressions);
            Condition = new ChildProperty<IExpression>(this, condition);
            NextExpressions = new ChildList<IExpression>(this);
            NextExpressions.AddRange(nextExpressions);
            Body = new ChildProperty<IStatement>(this, body);
        }
        
        public IEnumerable<VariableDeclaration> Variables => VariableDeclarations;
    }
}