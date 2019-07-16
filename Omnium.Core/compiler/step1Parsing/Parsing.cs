using Omnium.Core.ast.declarations;
using Omnium.Core.compiler.step1Parsing.antlr;

namespace Omnium.Core.compiler.step1Parsing
{
    public class Parsing : CompilationStep<string[], Root>
    {
        public override Root Run(string[] input)
        {
            var superComplexAst = AntlrParser.ParseAntlrAst(input);
            var ast = AstSimplifier.Simplify(superComplexAst);

            RunStep<ImportLinker>(ref ast);
            RunStep<VariableAssigner>(ref ast);
            RunStep<AstValidator>(ref ast);

            return ast;
        }
    }
}