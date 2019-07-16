using System;
using System.Linq;
using Omnium.Core.ast.declarations;

namespace Omnium.Core.compiler
{
    public abstract class CompilationStep<TIn, TOut>
    {
        public abstract TOut Run(TIn input);

        protected void RunStep<TWalker>(ref Root ast) where TWalker : TreeVoidWalker, new()
        {
            var walker = new TWalker();
            try
            {
                walker.Visit(ast);
            }
            catch (CompilationError e)
            {
                walker.Errors.Add(e);
            }
            foreach (var error in walker.Errors)
            {
                Console.WriteLine("ERROR " + error.Message);
            }
            foreach (var warning in walker.Warnings)
            {
                Console.WriteLine("WARNING " + warning.Message);
            }
            if (walker.Errors.Any())
            {
                ast = null;
            }
        }
    }
}