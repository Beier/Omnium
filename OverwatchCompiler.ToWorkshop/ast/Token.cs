using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast
{
    public class Token : Node
    {
        public virtual string Text => Context.GetText();
        public int Line => Context.GetTokens().Select(x => x.Line).First();
        public int Column => Context.GetTokens().Select(x => x.Column).First();

        public Token(IParseTree context) : base(context)
        {
        }
    }
}