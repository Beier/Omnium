using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class GetterSetterDeclaration : Node, INamedDeclaration
    {
        public string Name => Getter?.Name ?? Setter?.Name;
        public IType Type => Getter?.ReturnType ?? Setter?.Parameter?.Type;
        public GetterDeclaration Getter { get; set; }
        public SetterDeclaration Setter { get; set; }

        public GetterSetterDeclaration(IParseTree context) : base(context)
        {
        }
    }
}