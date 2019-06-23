using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class NativeMethodInvocationExpression : Node, IExpression
    {
        public readonly string NativeMethodName;
        public IType Type { get; set; }
        public IEnumerable<ITypeNode> ParameterTypes => Children.OfType<ITypeNode>();
        public IEnumerable<IExpression> Arguments => Children.OfType<IExpression>();
        public readonly bool ReadsState;
        public readonly bool ChangesState;
        public readonly bool ModifiesControlFlow;
        public bool CanBeMoved => !ReadsState && !ChangesState && !ModifiesControlFlow;

        public NativeMethodInvocationExpression(
            IParseTree context, 
            string nativeMethodName, 
            IType returnType,
            bool readsState,
            bool changesState,
            bool modifiesControlFlow,
            IEnumerable<INode> children) : base(context, children)
        {
            NativeMethodName = nativeMethodName;
            ReadsState = readsState;
            ChangesState = changesState;
            ModifiesControlFlow = modifiesControlFlow;
            Type = returnType;
        }

        public override string ToString()
        {
            if (!Arguments.Any())
                return NativeMethodName;
            return NativeMethodName + "(" + Arguments.MkString(", ") + ")";
        }
    }
}