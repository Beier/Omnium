using Omnium.Core.ast.declarations;

namespace Omnium.Core.compiler.step3FeatureSimplification
{
    public class FeatureSimplification : CompilationStep<Root, Root>
    {
        public override Root Run(Root ast)
        {
            RunStep<ReplacePlayerVars>(ref ast);
            RunStep<AssignmentSimplifier>(ref ast);
            RunStep<ClassDeleter>(ref ast);
            RunStep<GlobalVariableInitializer>(ref ast);
            RunStep<MethodFlattener>(ref ast);
            RunStep<LoopUnroller>(ref ast);
            RunStep<IfDeleter>(ref ast);

            return ast;
        }
    }
}