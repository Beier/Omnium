using System;
using System.Linq;
using Antlr4.Runtime;
using OverwatchCompiler.ToTypescript.antlr;
using OverwatchCompiler.ToTypescript.antlr.codeGeneration;

namespace OverwatchCompiler.ToTypescript
{
    public class OverwatchToTypescriptCompiler
    {
        public static string Compile(string filename)
        {
            var antlrStream = new AntlrFileStream(filename);
            var lexer = new OverwatchCodeLexer(antlrStream);
            var tokens = new CommonTokenStream(lexer);

            var parser = new OverwatchCodeParser(tokens);
            var errorListener = new ErrorListener(filename);
            var globalVariablesListener = new GlobalVariablesListener();
            parser.RemoveErrorListeners();
            parser.RemoveParseListeners();
            parser.AddErrorListener(errorListener);
            parser.AddParseListener(globalVariablesListener);
            var root = parser.root();

            foreach (var error in errorListener.Errors)
            {
                Console.WriteLine(error);
            }

            if (errorListener.Errors.Any())
            {
                throw new Exception("Compilation failed.");
            }

            var globalVariables = globalVariablesListener.GlobalVariables.ToList();
            var result = new CodeGeneration(globalVariables).Visit(root).ToString();
            return result;
        }
    }
}