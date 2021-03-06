﻿using System.Collections.Generic;
using System.IO;
using Antlr4.Runtime;

namespace Omnium.Core.compiler.step1Parsing.antlr
{
    public class ErrorListener : BaseErrorListener
    {
        private readonly string filename;
        public List<string> Errors { get; set; } = new List<string>();

        public ErrorListener(string filename)
        {
            this.filename = filename;
        }

        public override void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            Errors.Add($"{filename}:{line}:{charPositionInLine}: {msg}");
            base.SyntaxError(output, recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        }
    }
}