using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class MethodInvocationExpression : Expression
    {
        public IExpression Base => Children.OfType<IExpression>().First();
        public IEnumerable<ITypeNode> GenericTypes => Children.OfType<ITypeNode>();
        public IEnumerable<IExpression> Arguments => Children.OfType<IExpression>().Skip(1);
        public MethodDeclaration Target => Base is SimpleNameExpression simpleNameExpression ? simpleNameExpression.Declaration as MethodDeclaration
            : Base is MemberExpression memberExpression ? memberExpression.Declaration as MethodDeclaration
            : null;

        public MethodInvocationExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}