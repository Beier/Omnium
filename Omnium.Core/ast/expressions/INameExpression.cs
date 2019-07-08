using Omnium.Core.ast.declarations;

namespace Omnium.Core.ast.expressions
{
    public interface INameExpression : IExpression
    {
        INamedDeclaration Declaration { get; set; }
    }
}