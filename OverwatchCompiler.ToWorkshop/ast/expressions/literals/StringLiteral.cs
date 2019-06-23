using System;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions.literals
{
    public class StringLiteral : Token, ILiteral
    {
        public IType Type { get; set; }
        public string UnquotedText => Text.Substring(1, Text.Length - 2);

        public StringLiteral(IParseTree context) : base(context)
        {
        }

        public StringLiteral(IParseTree context, string overrideText) : base(context, overrideText)
        {
            if (!overrideText.StartsWith("\""))
                throw new Exception();
            if (!overrideText.EndsWith("\""))
                throw new Exception();
        }
    }
}