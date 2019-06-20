using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class NullType : IType
    {
        public override string ToString()
        {
            return "null";
        }
    }
}