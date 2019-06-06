using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.extensions
{
    public static class RuleContextExtensions
    {
        public static T GetNearestAncestorOfType<T>(this IParseTree context) where T : class
        {
            if (context == null)
                return null;
            if (context is T variable)
                return variable;
            return context.Parent.GetNearestAncestorOfType<T>();
        }

        public static IParseTree GetNearestAncestorOfTypes(this IParseTree context, params Type[] types)
        {
            if (context == null)
                return null;
            if (types.Contains(context.GetType()))
                return context;
            return context.Parent.GetNearestAncestorOfTypes(types);
        }

        public static string GetPositionString(this IParseTree context)
        {
            var sourceFile = context.GetNearestAncestorOfType<TypescriptParser.SourceFileContext>();
            var token = context.GetTokens().First();
            return $"{sourceFile.FilePath} ({token.Line}, {token.Column})";
        }

        public static IEnumerable<IToken> GetTokens(this IParseTree context)
        {
            return context.DecendantsOfType<ITerminalNode>().Select(x => x.Symbol);
        }

        public static IEnumerable<T> DecendantsOfType<T>(this IParseTree context)
        {
            if (context is T matchingDecendant)
                yield return matchingDecendant;
            for (int i = 0; i < context.ChildCount; i++)
            {
                var child = context.GetChild(i);
                foreach (var childResult in child.DecendantsOfType<T>())
                {
                    yield return childResult;
                }
            }
        }

        public static string MkString(this IEnumerable<object> objects, string seperator = "")
        {
            return string.Join(seperator, objects);
        }

    }
}