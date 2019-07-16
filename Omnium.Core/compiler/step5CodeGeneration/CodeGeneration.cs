using System;
using Omnium.Core.ast.declarations;

namespace Omnium.Core.compiler.step5CodeGeneration
{
    public class CodeGeneration : CompilationStep<Root, string>
    {
        public override string Run(Root ast)
        {
            RunStep<StringProcessor>(ref ast);

            if (ast == null)
                return null;

            try
            {
                var codeGenerator = new CodeGenerator();
                return codeGenerator.Visit(ast).ToString();
            }
            catch (CompilationError error)
            {
                Console.WriteLine("ERROR " + error.Message);
                return null;
            }
        }
    }
}