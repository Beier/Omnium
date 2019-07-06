using OverwatchCompiler.ToWorkshop.ast.declarations;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public interface INameExpression : IExpression
    {
        INamedDeclaration Declaration { get; set; }
    }
}