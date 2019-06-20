using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.statements;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class LambdaExpression : Expression, IHasVariables
    {
        public readonly ChildList<VariableDeclaration> Parameters;
        public readonly ChildProperty<BlockStatement> Block;
        public readonly ChildProperty<IExpression> ExpressionBody;

        public LambdaExpression(IParseTree context, IEnumerable<VariableDeclaration> parameters, BlockStatement block, IExpression expressionBody) : base(context)
        {
            Parameters = new ChildList<VariableDeclaration>(this);
            Parameters.AddRange(parameters);
            Block = new ChildProperty<BlockStatement>(this, block);
            ExpressionBody = new ChildProperty<IExpression>(this, expressionBody);
        }


        public IEnumerable<VariableDeclaration> Variables => Parameters;
    }
}