using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class VariableDeclarationStatement : Node, IStatement
    {
        public readonly ChildProperty<VariableDeclaration> VariableDeclaration;

        public VariableDeclarationStatement(IParseTree context, VariableDeclaration variableDeclaration) : base(context)
        {
            VariableDeclaration = new ChildProperty<VariableDeclaration>(this, variableDeclaration);
        }
    }
}