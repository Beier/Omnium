using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.compiler.parsing;

namespace OverwatchCompiler.ToWorkshop.compiler
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
                new VariableAssigner(),
                new AstValidator(),
                new TypeLinker(),
                new NativeLoader(), 
                new ExpressionTypeAssignerAndMethodLinker()
            };

            foreach (var step in astTraversalSteps)
            {
                step.Visit(root);
                foreach (var error in step.Errors)
                {
                    Console.WriteLine(error.Message);
                }
                if (step.Errors.Any())
                {
                    throw new Exception("Compilation failed.");
                }
            }

            var result = "";
            return result;
        }
    }
}