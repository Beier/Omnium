using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class NativeMethodInvocationExpression : Node, IExpression
    {
        public readonly string NativeMethodName;
        public IType Type { get; set; }
        public readonly ChildList<ITypeNode> ParameterTypes;
        public readonly ChildList<IExpression> Arguments;

        public NativeMethodInvocationExpression(
            IParseTree context, 
            string nativeMethodName, 
            IEnumerable<ITypeNode> parameterTypes,
            IEnumerable<IExpression> parameters, 
            IType returnType) : base(context)
        {
            NativeMethodName = nativeMethodName;
            ParameterTypes = new ChildList<ITypeNode>(this);
            ParameterTypes.AddRange(parameterTypes);
            Arguments = new ChildList<IExpression>(this);
            Arguments.AddRange(parameters);
            Type = returnType;
        }
    }
}