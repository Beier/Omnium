using Omnium.Core.ast.declarations;
using Omnium.Core.compiler.step1Parsing;
using Omnium.Core.compiler.step2TypeAssignment;
using Omnium.Core.compiler.step3FeatureSimplification;
using Omnium.Core.compiler.step4CodeOptimization;
using Omnium.Core.compiler.step5CodeGeneration;

namespace Omnium.Core.compiler
{
    public class TypescriptToOverwatchCompiler
    {
        public string Compile(string filename)
        {
            return Compile(new[] {filename});
        }

        public string Compile(string[] filenames)
        {
            var ast = Run<Parsing, string[], Root>(filenames);
            Run<TypeAssignment>(ref ast);
            Run<FeatureSimplification>(ref ast);
            Run<CodeOptimization>(ref ast);
            var overwatchCode = Run<CodeGeneration, Root, string>(ast);

            return overwatchCode;
        }

        private void Run<TStep>(ref Root ast) where TStep : CompilationStep<Root, Root>, new()
        {
            ast = Run<TStep, Root, Root>(ast);
        }

        private TOut Run<TStep, TIn, TOut>(TIn input) where TStep : CompilationStep<TIn, TOut>, new()
        {
            var step = new TStep();
            return step.Run(input);
        }
    }
}