using Omnium.Core.ast.statements;

namespace Omnium.Core.compiler.step1Parsing
{
    public class VariableAssigner : TreeVoidWalker
    {
        public override void ExitVariableDeclarationStatement(VariableDeclarationStatement variableDeclaration)
        {
            var parent = variableDeclaration.Parent;
            if (!(parent is BlockStatement block))
            {
                Errors.Add(new CompilationError(variableDeclaration.Context, "Variable must be declared in a block."));
                return;
            }
            block.VariableDeclarations.Add(variableDeclaration.VariableDeclaration);
        }
    }
}