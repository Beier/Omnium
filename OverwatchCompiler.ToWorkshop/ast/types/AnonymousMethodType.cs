using System.Linq;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
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
            return "(" + Expression.Parameters.Select(x => x.Type.Value).MkString(", ") + ") => " + ReturnType;
        }
    }
}