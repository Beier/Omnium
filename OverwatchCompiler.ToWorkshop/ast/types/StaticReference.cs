using System.Linq;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class StaticReference : IType
    {
        public INode Declaration { get; }

        public StaticReference(INode declaration)
        {
            Declaration = declaration;
        }

        public override string ToString()
        {
            return "static " + Declaration.AllAncestorsAndSelf().OfType<INamedDeclaration>().Select(x => x.Name).MkString(".");
        }
    }
}