using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;
using CommandLine;
using OverwatchCompiler.ToTypescript.antlr;
using Parser = CommandLine.Parser;


namespace OverwatchCompiler.ToTypescript
{
    class Program
    {

        public class Options
        {
            [Option('i', "input", Required = true, HelpText = "Input file to compile.")]
            public string Input { get; set; }

            [Option('o', "output", Required = true, HelpText = "File to write compiled code to. This file will be overwritten if it exists.")]
            public string Output { get; set; }
        }

        static void Main(string[] args)
        {
            Parser.Default.ParseArguments<Options>(args)
                .WithParsed(parsedArgs =>
                {
                    var code = OverwatchToTypescriptCompiler.Compile(parsedArgs.Input);
                    File.WriteAllText(parsedArgs.Output, code, Encoding.UTF8);
                });
        }
    }
}
