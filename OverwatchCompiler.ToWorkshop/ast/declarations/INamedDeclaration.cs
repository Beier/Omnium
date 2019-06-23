namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public interface INamedDeclaration : INode
    {
        string Name { get; }
    }
}