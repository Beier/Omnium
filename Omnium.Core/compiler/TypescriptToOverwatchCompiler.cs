using System;
using System.Linq;
using Omnium.Core.compiler.parsing;

namespace Omnium.Core.compiler
{
    public class TypescriptToOverwatchCompiler
    {
        private readonly IParser parser;


        public TypescriptToOverwatchCompiler()
        {
            parser = new Parser();
        }

        public TypescriptToOverwatchCompiler(IParser parser)
        {
            this.parser = parser;
        }

        public string Compile(string filename)
        {
            return Compile(new[] {filename});
        }

        public string Compile(string[] filenames)
        {
            var root = parser.LoadFileAndImports(filenames);
            
            var astTraversalSteps = new TreeVoidWalker[]
            {
                new ImportLinker(),
                new VariableAssigner(),
                new AstValidator(),
                new TypeLinker(),
                new NativeLoader(), 
                new ExpressionTypeAssignerAndMethodLinker(),
                new ReplacePlayerVars(),
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
                    return null;
                }
            }

            /*
             *  Todo:
             *  - Reevaluate: Do not merge with assignments after
             *  - Refactor: Split into folders
             *  - Optional types
             *      - Generics. Eg. list.sortedBy<number>(x => x)
             *
             */


            var result = new CodeGenerator().Visit(root).ToString();
            return result;
        }
    }
}