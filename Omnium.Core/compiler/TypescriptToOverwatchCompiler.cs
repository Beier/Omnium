using System;
using System.Linq;
using Omnium.Core.compiler.parsing;

namespace Omnium.Core.compiler
{
    public class TypescriptToOverwatchCompiler
    {
        private readonly IParser parser;


        public TypescriptToOverwatchCompiler(IParser parser)
        {
            this.parser = parser;
        }

        public string Compile(string filename)
        {
            var root = parser.LoadFileAndImports(filename);

            //Todo: Extract
            var astTraversalSteps = new TreeVoidWalker[]
            {
                new ImportLinker(), 
                new ClassMerger(), 
                new VariableAssigner(),
                new AstValidator(),
                new TypeLinker(),
                new NativeLoader(), 
                new ExpressionTypeAssignerAndMethodLinker(),
                new AssignmentSimplifier(), 
                new ClassDeleter(), 
                new GlobalVariableInitializer(), 
                new MethodFlattener(),
                new LoopUnroller(),
                new IfDeleter(), 
                new VariableRemoverAndCodeOptimizer(),
                new StringProcessor()
            };

            foreach (var step in astTraversalSteps)
            {
                try
                {
                    step.Visit(root);
                }
                catch (CompilationError e)
                {
                    step.Errors.Add(e);
                }
                foreach (var error in step.Errors)
                {
                    Console.WriteLine("ERROR " + error.Message);
                }
                foreach (var warning in step.Warnings)
                {
                    Console.WriteLine("WARNING " + warning.Message);
                }
                if (step.Errors.Any())
                {
                    throw new Exception("Compilation failed.");
                }
            }

            /*
             *  Todo:
             *  - Chase: Single global variable
             *  - Reevaluate: Do not merge with assignments after
             *  - Constant native methods
             *  - Refactor: Split into folders
             *  - Optional types
             *
             *
             */


            var result = new CodeGenerator().Visit(root).ToString();
            return result;
        }
    }
}