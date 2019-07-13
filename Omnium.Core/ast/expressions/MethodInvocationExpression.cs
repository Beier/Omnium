using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.expressions
{
    public class MethodInvocationExpression : Expression
    {
        public IExpression Base => Children.OfType<IExpression>().First();
        public IEnumerable<ITypeNode> GenericTypes => Children.OfType<ITypeNode>();
        public IEnumerable<IExpression> Arguments => Children.OfType<IExpression>().Skip(1);
        public MethodDeclaration Target => Base is SimpleNameExpression simpleNameExpression ? simpleNameExpression.Declaration as MethodDeclaration
            : Base is MemberExpression memberExpression ? memberExpression.Declaration as MethodDeclaration
            : null;

        public bool isNativeRegisterReevaluation = false;

        public MethodInvocationExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        public override string ToString()
        {
            var genericTypesString = GenericTypes.Any() ? $"<{GenericTypes.MkString(", ")}>" : null;
            return $"{Base}{genericTypesString}({Arguments.MkString(", ")})";
        }
    }
}