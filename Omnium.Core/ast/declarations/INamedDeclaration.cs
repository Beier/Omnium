namespace Omnium.Core.ast.declarations
{
    public interface INamedDeclaration : INode
    {
        string Name { get; }
    }
}