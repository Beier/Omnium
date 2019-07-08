using System.Linq;
using Omnium.Core.ast.expressions;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.types
{
    public class AnonymousMethodType : IType
    {
        public LambdaExpression Expression { get; }
        public IType ReturnType { get; }

        public AnonymousMethodType(LambdaExpression expression, IType returnType)
        {
            Expression = expression;
            ReturnType = returnType;
        }

        public override string ToString()
        {
            return "(" + Expression.Variables.Select(x => x.Type).MkString(", ") + ") => " + ReturnType;
        }
    }
}