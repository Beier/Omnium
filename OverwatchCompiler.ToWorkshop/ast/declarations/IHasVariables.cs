using System.Collections.Generic;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public interface IHasVariables : INode
    {
        IEnumerable<VariableDeclaration> Variables { get; }
    }
}