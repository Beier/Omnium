using System.Collections.Generic;

namespace Omnium.Core.ast.declarations
{
    public interface IHasVariables : INode
    {
        IEnumerable<VariableDeclaration> Variables { get; }
    }
}