using Omnium.Core.ast.declarations;

namespace Omnium.Core.compiler.step4CodeOptimization
{
    public class CodeOptimization : CompilationStep<Root, Root>
    {
        public override Root Run(Root ast)
        {
            RunStep<VariableRemoverAndCodeOptimizer>(ref ast);

            return ast;
        }
    }
}