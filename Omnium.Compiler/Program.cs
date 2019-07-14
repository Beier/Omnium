using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using CommandLine;
using Omnium.Core.ast;
using Omnium.Core.compiler;

namespace Omnium
{
    class Program
    {
        public class Options
        {
            [Option('i', "inputFiles", Required = true, HelpText = "Path to one or more input files. Imported files will automatically be included.")]
            public IEnumerable<string> InputFiles { get; set; }
            [Option('o', "outputFile", Required = true, HelpText = "Path to output file")]
            public string OutputFile { get; set; }
        }

        static void Main(string[] args)
        {
            Parser.Default.ParseArguments<Options>(args)
                .WithParsed(options =>
                {
                    var compiler = new TypescriptToOverwatchCompiler();
                    try
                    {
                        var result = compiler.Compile(options.InputFiles.ToArray());
                        if (result == null)
                        {
                            Console.WriteLine("Build failed!");
                            return;
                        }

                        using (var outputStream = new StreamWriter(File.Create(options.OutputFile)))
                        {
                            outputStream.Write(result);
                        }
                        Console.WriteLine("Build succeeded");
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine("Internal error occured: " + e);
                    }
                });
        }
    }

}
