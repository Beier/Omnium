using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using Antlr4.Runtime;

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

            var result = "";
            return result;
        }
    }
}