using System;
using System.Linq;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class CompilationError : Exception
    {
        public CompilationError(IParseTree context, string message) : base(AddContextToMessage(context, message))
        {
        }

        public CompilationError(IParseTree context, string message, Exception innerException) : base(AddContextToMessage(context, message), innerException)
        {
        }

        private static string AddContextToMessage(IParseTree context, string message)
        {
            if (context != null)
                return $"{context.GetPositionString()}: {message}";
            return message;
        }
    }
}