using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;
using Omnium.Core.compiler.utilities;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler.step2TypeAssignment.expressionTypeAssignerAndMethodLinker
{
    public partial class ExpressionTypeAssignerAndMethodLinker : TreeVoidWalker
    {


        public override void EnterLambdaExpression(LambdaExpression lambdaExpression)
        {
            if (lambdaExpression.Variables.All(x => x.Type != null))
                return;
            switch (lambdaExpression.Parent)
            {
                case MethodInvocationExpression methodInvocationExpression:
                    {
                        var methodReferenceType = methodInvocationExpression.Base.Type.Unwrap() as MethodReferenceType;
                        var argumentIndex = methodInvocationExpression.Arguments.IndexOf(lambdaExpression);
                        if (methodReferenceType == null || argumentIndex == -1)
                            break;
                        var targetParameter = methodReferenceType.Declaration.Variables.Skip(argumentIndex).FirstOrDefault();
                        if (!(targetParameter?.Type is FunctionType functionType) || functionType.Parameters.Count() != lambdaExpression.Variables.Count())
                            break;
                        for (int i = 0; i < lambdaExpression.Variables.Count(); i++)
                        {
                            var typeNode = ReplaceGenerics(methodInvocationExpression, functionType.Parameters.ElementAt(i).Type);
                            lambdaExpression.Variables.ElementAt(i).AddChild(typeNode);
                        }
                        return;
                    }
                case VariableDeclaration variableDeclaration:
                    {
                        if (variableDeclaration.Type == null || !(variableDeclaration.Type is FunctionType functionType) || functionType.Parameters.Count() != lambdaExpression.Variables.Count())
                            break;
                        for (int i = 0; i < lambdaExpression.Variables.Count(); i++)
                        {
                            lambdaExpression.Variables.ElementAt(i).AddChild(AstCloner.Clone(functionType.Parameters.ElementAt(i).Type));
                        }
                        return;
                    }
                case AssignmentExpression assignmentExpression:
                {
                    if (!(assignmentExpression.Left is INameExpression nameExpression))
                        break;
                    switch (nameExpression.Declaration)
                    {
                        case VariableDeclaration variableDeclaration:
                        {
                            if (variableDeclaration.Type == null || !(variableDeclaration.Type is FunctionType functionType) || functionType.Parameters.Count() != lambdaExpression.Variables.Count())
                                break;
                            for (int i = 0; i < lambdaExpression.Variables.Count(); i++)
                            {
                                lambdaExpression.Variables.ElementAt(i).AddChild(AstCloner.Clone(functionType.Parameters.ElementAt(i).Type));
                            }
                            return;
                                }
                        case GetterSetterDeclaration getterSetterDeclaration:
                        {
                            if (!(getterSetterDeclaration.Type is FunctionType functionType) || functionType.Parameters.Count() != lambdaExpression.Variables.Count())
                                break;
                            for (int i = 0; i < lambdaExpression.Variables.Count(); i++)
                            {
                                lambdaExpression.Variables.ElementAt(i).AddChild(AstCloner.Clone(functionType.Parameters.ElementAt(i).Type));
                            }
                            return;
                        }
                    }

                    break;
                }
            }
            throw new CompilationError(lambdaExpression.Context, "Unable to infer parameter types");
        }

        public override void ExitLambdaExpression(LambdaExpression lambdaExpression)
        {
            var returnTypes = lambdaExpression.Block
                    .AllDescendantsAndSelf()
                    .OfType<ReturnStatement>()
                    .Where(x => x.NearestAncestorOfType<LambdaExpression>() == lambdaExpression)
                    .Select(x => x.Value == null ? new VoidType(x.Context) : x.Value.Type)
                    .ToList();
            IType returnType = new VoidType(lambdaExpression.Context);
            for (int i = 0; i < returnTypes.Count(); i++)
            {
                if (returnType is VoidType || returnType is NullType)
                    returnType = returnTypes[i];
                for (int j = i + 1; j < returnTypes.Count(); j++)
                {
                    if (returnTypes[i].IsEquivalentTo(returnTypes[j]))
                        Errors.Add(new CompilationError(lambdaExpression.Context, "All return statements of a function must return the same type"));
                }
            }
            lambdaExpression.Type = new AnonymousMethodType(lambdaExpression, returnType);
        }
        
        public override void EnterMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression)
        {
            if (methodInvocationExpression.Base is MemberExpression memberExpression)
            {
                switch (memberExpression.Name)
                {
                    case "toString":
                        {
                            if (methodInvocationExpression.GenericTypes.Any())
                                Errors.Add(new CompilationError(memberExpression.Context, "Expected 0 generic type arguments"));
                            if (methodInvocationExpression.Arguments.Any())
                                Errors.Add(new CompilationError(memberExpression.Context, "Expected 0 arguments"));
                            var replacement = memberExpression.Base;
                            methodInvocationExpression.ReplaceWith(replacement);
                            var parent = replacement.Parent;
                            var index = parent.Children.IndexOf(replacement);
                            Visit(replacement);
                            if (replacement.Parent == null)
                                replacement = (IExpression)parent.Children.ElementAt(index);
                            replacement.Type = new StringType(methodInvocationExpression.Context);
                            skipChildren = true;
                            break;
                        }
                }
            }

            if (methodInvocationExpression.isNativeRegisterReevaluation)
            {
                var nativeMethodName = ((StringLiteral) methodInvocationExpression.Arguments.ElementAt(0)).UnquotedText;
                var reevaluationEnumParameter = (int)((NumberLiteral) methodInvocationExpression.Arguments.ElementAt(1)).Value;
                Visit(methodInvocationExpression.Arguments.ElementAt(2));
                var enumValue = (methodInvocationExpression.Arguments.ElementAt(2) as INameExpression)?.Declaration as EnumValue;
                var reevaluatedParameter = (int)((NumberLiteral)methodInvocationExpression.Arguments.ElementAt(3)).Value;

                if (enumValue == null)
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, "The thrid argument must be an enum value"));
                else
                {
                    var root = methodInvocationExpression.NearestAncestorOfType<Root>();
                    root.ReevaluationRegistrations.Add(new ReevaluationRegistration(nativeMethodName, reevaluationEnumParameter, enumValue, reevaluatedParameter));
                }
                
                methodInvocationExpression.Remove();

                skipChildren = true;
                return;
            }
        }

        public override void ExitMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression)
        {
            if (methodInvocationExpression.Parent == null)
                return;
            switch (methodInvocationExpression.Base.Type.Unwrap())
            {
                case MethodReferenceType methodReference:
                    if (methodInvocationExpression.GenericTypes.Count() != methodReference.Declaration.GenericTypeDeclarations.Count())
                        Errors.Add(new CompilationError(methodInvocationExpression.Context, $"Target method has {methodReference.Declaration.GenericTypeDeclarations.Count()} generic variables, but is invoked with {methodInvocationExpression.GenericTypes.Count()}"));


                    var defaultParametersCount = methodReference.Declaration.Variables.Count(x => x.InitExpression != null);
                    if (methodInvocationExpression.Arguments.Count() < methodReference.Declaration.Variables.Count() - defaultParametersCount
                        || methodInvocationExpression.Arguments.Count() > methodReference.Declaration.Variables.Count())
                        Errors.Add(new CompilationError(methodInvocationExpression.Context, $"Target method has {methodReference.Declaration.Variables.Count()} parameters, but is invoked with {methodInvocationExpression.Arguments.Count()}"));
                    else
                    {
                        var arguments = methodInvocationExpression.Arguments.ToList();
                        var parameters = methodReference.Declaration.Variables.ToList();
                        for (int i = 0; i < arguments.Count; i++)
                        {
                            var fromType = arguments[i].Type;
                            var toType = ReplaceGenerics(methodInvocationExpression, parameters[i].Type);
                            if (!fromType.IsAssignableTo(toType))
                                Errors.Add(new CompilationError(arguments[i].Context, $"Can not assign {fromType} to {toType}"));
                        }
                    }

                    if (methodReference.Declaration.ReturnType == null)
                    {
                        Visit(methodReference.Declaration);
                    }

                    methodInvocationExpression.Type = ReplaceGenerics(methodInvocationExpression, methodReference.Declaration.ReturnType);
                    break;
                case AnonymousMethodType _:
                case FunctionType _:
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, "Explicit evaluation of lambda function is not possible in the target language."));
                    methodInvocationExpression.Type = new NullType();
                    break;
                default:
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, $"Base type '{methodInvocationExpression.Base.Type}' is not a method"));
                    methodInvocationExpression.Type = new NullType();
                    break;
            }
        }

        public override void ExitListLambdaExpression(ListLambdaExpression listLambdaExpression)
        {
            listLambdaExpression.Type = listLambdaExpression.ReturnType;
        }

        private ITypeNode ReplaceGenerics(INode methodInvocationOrMemberExpression, ITypeNode type)
        {
            var clone = AstCloner.Clone(type);
            foreach (var referenceType in clone.AllDescendantsAndSelf().OfType<ReferenceType>().ToList())
            {
                if (!(referenceType.Declaration is GenericTypeDeclaration genericTargetDeclaration))
                    continue;
                if (methodInvocationOrMemberExpression.IsDescendantOf(genericTargetDeclaration.Parent))
                    continue;
                List<GenericTypeDeclaration> genericList;
                List<ITypeNode> typeList;
                switch (genericTargetDeclaration.Parent)
                {
                    case MethodDeclaration method:
                        genericList = method.GenericTypeDeclarations.ToList();
                        typeList = ((MethodInvocationExpression)methodInvocationOrMemberExpression).GenericTypes.ToList();
                        break;
                    case ClassDeclaration classDeclaration:
                        genericList = classDeclaration.GenericTypeDeclarations.ToList();
                        var baseMember = methodInvocationOrMemberExpression is MethodInvocationExpression
                            ? (((MethodInvocationExpression)methodInvocationOrMemberExpression).Base as MemberExpression)?.Base
                            : ((MemberExpression)methodInvocationOrMemberExpression).Base;
                        if (baseMember == null || !(baseMember.Type is GenericType genericType))
                            throw new CompilationError(methodInvocationOrMemberExpression.Context, "Expected generic type parameters");
                        typeList = genericType.GenericTypes.ToList();
                        break;
                    default:
                        throw new Exception("Unexpected method parent: " + genericTargetDeclaration.Parent);
                }

                if (genericList.Count != typeList.Count)
                    throw new CompilationError(methodInvocationOrMemberExpression.Context, $"Expected {genericList.Count} generic type parameters, but got {typeList}");
                var index = genericList.IndexOf(genericTargetDeclaration);
                var replacement = AstCloner.Clone(typeList[index]);
                if (referenceType.Parent == null)
                    clone = replacement;
                else
                    referenceType.ReplaceWith(replacement);
            }

            return clone;
        }

    }
}