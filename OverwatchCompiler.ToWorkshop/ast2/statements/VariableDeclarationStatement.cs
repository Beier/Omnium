using System.Runtime.Remoting.Messaging;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast2.declarations;

namespace OverwatchCompiler.ToWorkshop.ast2.statements
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