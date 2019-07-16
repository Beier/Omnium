using Omnium.Core.ast.declarations;

namespace Omnium.Core.compiler.step2TypeAssignment
{
    public class TypeAssignment : CompilationStep<Root, Root>
    {
        public override Root Run(Root ast)
        {
            RunStep<TypeLinker>(ref ast);
            RunStep<NativeLoader>(ref ast);
            RunStep<ExpressionTypeAssignerAndMethodLinker>(ref ast);
            return ast;
        }
    }
}