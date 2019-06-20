using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class GetterSetterDeclaration : INamedDeclaration
    {
        public string Name => Getter?.Name ?? Setter?.Name;
        public IType Type => Getter?.ReturnType.Value ?? Setter?.Parameter.Value?.Type.Value;
        public GetterDeclaration Getter { get; set; }
        public SetterDeclaration Setter { get; set; }
    }
}