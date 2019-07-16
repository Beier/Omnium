using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler.utilities
{
    public static class NativeMethods
    {
        public static IEnumerable<string> ModifyingControlFlow
        {
            get
            {
                yield return "Loop";
                yield return "Loop If";
                yield return "Loop If Condition Is False";
                yield return "Loop If Condition Is True";
                yield return "Skip";
                yield return "Skip If";
            }
        }

        public static NativeMethodInvocationExpression ArrayCount(IParseTree context, IExpression array)
        {
            return new NativeMethodInvocationExpression(
                context,
                nativeMethodName: "Count Of",
                returnType: new NumberType(context),
                readsState: true,
                changesState: false,
                modifiesControlFlow: false,
                children: array.Yield());
        }

        public static NativeMethodInvocationExpression ArrayIndex(IParseTree context, IExpression array, IExpression index)
        {
            var baseType = ((GenericType)array.Type).GenericTypes.Single();
            return new NativeMethodInvocationExpression(
                context,
                nativeMethodName: "Value In Array",
                returnType: baseType,
                readsState: true,
                changesState: false,
                modifiesControlFlow: false,
                children: new INode[] { array, index });
        }

        public static ExpressionStatement Loop(IParseTree context)
        {
            return new ExpressionStatement(context,
                new NativeMethodInvocationExpression(
                    context,
                    nativeMethodName: "Loop",
                    returnType: new VoidType(context),
                    readsState: false,
                    changesState: false,
                    modifiesControlFlow: true,
                    children: new INode[0])
                );
        }

        public static NativeMethodInvocationExpression EventPlayer(IParseTree context)
        {
            return new NativeMethodInvocationExpression(
                    context,
                    nativeMethodName: "Event player",
                    returnType: new NullType(),
                    readsState: false,
                    changesState: false,
                    modifiesControlFlow: false,
                    children: new INode[0]);
        }

        public static NativeMethodInvocationExpression CurrentArrayElement(IParseTree context)
        {
            return new NativeMethodInvocationExpression(
                    context,
                    nativeMethodName: "Current array element",
                    returnType: new NullType(),
                    readsState: false,
                    changesState: false,
                    modifiesControlFlow: false,
                    children: new INode[0]);
        }

        public static NativeMethodInvocationExpression FilteredArray(IParseTree context, IExpression list, IExpression condition)
        {
            return new NativeMethodInvocationExpression(
                    context,
                    nativeMethodName: "Filtered array",
                    returnType: new NullType(),
                    readsState: false,
                    changesState: false,
                    modifiesControlFlow: false,
                    children: new []{list, condition});
        }

        public static NativeMethodInvocationExpression ListLambda(IParseTree context, string name, IExpression list, IExpression condition)
        {
            return new NativeMethodInvocationExpression(
                    context,
                    nativeMethodName: name,
                    returnType: new NullType(),
                    readsState: false,
                    changesState: false,
                    modifiesControlFlow: false,
                    children: new []{list, condition});
        }

        public static NativeMethodInvocationExpression EmptyArray(IParseTree context, Root root, ITypeNode type)
        {
            return new NativeMethodInvocationExpression(
                context,
                nativeMethodName: "Empty Array",
                returnType: new GenericType(context, new []{new ReferenceType(context, root.ListDeclaration), AstCloner.Clone(type)}),
                readsState: false,
                changesState: false,
                modifiesControlFlow: false,
                children: new INode[0]);
        }

        public static NativeMethodInvocationExpression AppendToArray(IParseTree context, IExpression array, IExpression value)
        {
            return new NativeMethodInvocationExpression(
                context,
                nativeMethodName: "Append To Array",
                returnType: AstCloner.Clone((GenericType)array.Type),
                readsState: false,
                changesState: false,
                modifiesControlFlow: false,
                children: new INode[] { array, value }.Where(x => x != null));
        }

        public static NativeMethodInvocationExpression String(IParseTree context, StringLiteral literal, IExpression arg1 = null, IExpression arg2 = null, IExpression arg3 = null)
        {
            return new NativeMethodInvocationExpression(
                context,
                nativeMethodName: "String",
                returnType: new StringType(context),
                readsState: false,
                changesState: false,
                modifiesControlFlow: false,
                children: new INode[]
                {
                    literal,
                    arg1 ?? new NullLiteral(context),
                    arg2 ?? new NullLiteral(context),
                    arg3 ?? new NullLiteral(context)
                });
        }

        /*
         *actions
{
	Set Global Variable(A, Value In Array(Global Variable(A), 0));
}
         * actions
{
	Set Global Variable(A, Append To Array(All Players(All Teams), 0));
}
         */
    }
}