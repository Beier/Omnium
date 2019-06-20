using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class ForeachStatement : Node, IStatement, IHasVariables
    {
        public readonly ChildProperty<VariableDeclaration> Variable;
        public readonly ChildProperty<IExpression> List;
        public readonly ChildProperty<IStatement> Body;


        public ForeachStatement(IParseTree context, VariableDeclaration variable, IExpression list, IStatement body) : base(context)
        {
            Variable = new ChildProperty<VariableDeclaration>(this, variable);
            List = new ChildProperty<IExpression>(this, list);
            Body = new ChildProperty<IStatement>(this, body);
        }

        public IEnumerable<VariableDeclaration> Variables
        {
            get { yield return Variable.Value; }
        }
    }
}