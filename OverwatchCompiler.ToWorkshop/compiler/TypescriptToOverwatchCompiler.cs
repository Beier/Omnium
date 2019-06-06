using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.compiler.phases;

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
            var sourceFiles = parser.LoadFileAndImports(filename);

            var variableContextAssigner = new VariableContextAssigner();
            var walker = new ParseTreeWalker();
            walker.Walk(variableContextAssigner, sourceFiles);

            var result = "";
            return result;
        }
    }
}