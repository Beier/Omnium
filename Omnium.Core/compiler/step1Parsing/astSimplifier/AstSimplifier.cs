using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;

namespace Omnium.Core.compiler.step1Parsing.astSimplifier
{
    public partial class AstSimplifier : TypescriptParserBaseVisitor<IEnumerable<INode>>
    {
        public static Root Simplify(TypescriptParser.SourceFilesContext rootContext)
        {
            var simplifier = new AstSimplifier();
            return simplifier.Visit(rootContext).OfType<Root>().SingleOrDefault();
        }

        protected override IEnumerable<INode> DefaultResult => Enumerable.Empty<INode>();

        protected override IEnumerable<INode> AggregateResult(IEnumerable<INode> first, IEnumerable<INode> second)
        {
            return first.Concat(second);
        }

        public override IEnumerable<INode> Visit(IParseTree tree)
        {
            try
            {
                if (tree == null)
                    return Enumerable.Empty<INode>();
                return base.Visit(tree).ToList();
            }
            catch (CompilationError)
            {
                throw;
            }
            catch (Exception e)
            {
                throw new CompilationError(tree, "An internal error occured trying to simplify the AST", e);
            }
        }
    }
}