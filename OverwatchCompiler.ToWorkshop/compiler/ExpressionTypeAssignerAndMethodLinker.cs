using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.expressions.literals;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class ExpressionTypeAssignerAndMethodLinker : TreeVoidWalker
    {
        public override void ExitSimpleNameExpression(SimpleNameExpression simpleNameExpression)
        {
            var ancestors = simpleNameExpression.AllAncestorsAndSelf()
                .OfAnyType(typeof(IHasVariables),
                typeof(ClassDeclaration),
                typeof(ModuleDeclaration),
                typeof(SourceFile));

            foreach (var ancestor in ancestors)
            {
                var declarations = GetMatchingDeclarations(ancestor, simpleNameExpression.Name);
                if (declarations.Count == 0)
                    continue;
                if (declarations.Count > 1)
                    Errors.Add(new CompilationError(simpleNameExpression.Context, $"Found multiple declarations matching '{simpleNameExpression.Name}'"));

                simpleNameExpression.Declaration = declarations.First();
                simpleNameExpression.Type = GetType(simpleNameExpression.Declaration);
                return;
            }

            var root = simpleNameExpression.NearestAncestorOfType<Root>();
            var matchingNativeDeclarations = root.NativeMethods.Where(x => x.TypescriptNames[0] == simpleNameExpression.Name).ToList();

            if (matchingNativeDeclarations.Exists(x => x.TypescriptNames.Count == 1))
            {
                if (matchingNativeDeclarations.Count > 1)
                    Errors.Add(new CompilationError(simpleNameExpression.Context, $"Found multiple native declarations matching '{simpleNameExpression.Name}'"));
                simpleNameExpression.Type = new NativeMethodType(matchingNativeDeclarations.First(x => x.TypescriptNames.Count == 1));
                return;
            }

            if (matchingNativeDeclarations.Count > 0)
            {
                simpleNameExpression.Type = new PartialNativeMethodType(matchingNativeDeclarations, 1);
                return;
            }

            throw new CompilationError(simpleNameExpression.Context, $"Found no declarations matching '{simpleNameExpression.Name}'");
        }

        private static List<INamedDeclaration> GetMatchingDeclarations(INode ancestor, string name)
        {
            var matchingDeclarations = new List<INamedDeclaration>();
            if (ancestor is IHasVariables variableContainer)
            {
                matchingDeclarations.AddRange(variableContainer.Variables.Where(x => x.Name == name));
            }

            if (ancestor is ClassDeclaration classDeclaration)
            {
                matchingDeclarations.AddRange(classDeclaration.GettersAndSetters.Where(x => x.Name == name));
                matchingDeclarations.AddRange(classDeclaration.MethodDeclarations.Where(x => x.Name == name));
            }

            if (ancestor is AbstractTopLevelNode topLevelNode)
            {
                matchingDeclarations.AddRange(topLevelNode.ModuleDeclarations.Where(x => x.Name == name));
                matchingDeclarations.AddRange(topLevelNode.ClassDeclarations.Where(x => x.Name == name));
                matchingDeclarations.AddRange(topLevelNode.EnumDeclarations.Where(x => x.Name == name));
                matchingDeclarations.AddRange(topLevelNode.MethodDeclarations.Where(x => x.Name == name));
            }

            if (ancestor is SourceFile sourceFile)
            {
                foreach (var importedSourceFile in sourceFile.ImportedSourceFiles)
                {
                    matchingDeclarations.AddRange(importedSourceFile.ModuleDeclarations.Where(x => x.Name == name));
                    matchingDeclarations.AddRange(importedSourceFile.ClassDeclarations.Where(x => x.Name == name));
                    matchingDeclarations.AddRange(importedSourceFile.EnumDeclarations.Where(x => x.Name == name));
                }
            }

            return matchingDeclarations;
        }

        private static bool IsStatic(INamedDeclaration declaration)
        {
            switch (declaration)
            {
                case VariableDeclaration variableDeclaration:
                    return variableDeclaration.Modifiers.Contains(MemberModifier.Static);
                case GetterSetterDeclaration getterSetterDeclaration:
                    if (getterSetterDeclaration.Getter != null)
                        return getterSetterDeclaration.Getter.Modifiers.Contains(MemberModifier.Static);
                    return getterSetterDeclaration.Setter.Modifiers.Contains(MemberModifier.Static);
                case MethodDeclaration methodDeclaration:
                    return methodDeclaration.Modifiers.Contains(MemberModifier.Static);
                case ModuleDeclaration _:
                case ClassDeclaration _:
                case EnumDeclaration _:
                    return true;
                default:
                    throw new Exception("Unexpected declaration: " + declaration?.GetType().FullName);
            }
        }

        private static IType GetType(INamedDeclaration declaration)
        {
            switch (declaration)
            {
                case VariableDeclaration variableDeclaration:
                    return variableDeclaration.Type.Value;
                case GetterSetterDeclaration getterSetterDeclaration:
                    return getterSetterDeclaration.Type;
                case MethodDeclaration methodDeclaration:
                    return new MethodReferenceType(methodDeclaration);
                case ModuleDeclaration moduleDeclaration:
                    return new StaticReference(moduleDeclaration);
                case ClassDeclaration classDeclaration:
                    return new StaticReference(classDeclaration);
                case EnumDeclaration enumDeclaration:
                    return new StaticReference(enumDeclaration);
                default:
                    throw new Exception("Unexpected declaration: " + declaration?.GetType().FullName);
            }
        }

        public override void ExitBooleanLiteral(BooleanLiteral booleanLiteral)
        {
            booleanLiteral.Type = new BoolType(booleanLiteral.Context);
        }

        public override void ExitNullLiteral(NullLiteral nullLiteral)
        {
            nullLiteral.Type = new ReferenceType(nullLiteral.Context, new Token[0]);
        }

        public override void ExitNumberLiteral(NumberLiteral numberLiteral)
        {
            numberLiteral.Type = new NumberType(numberLiteral.Context);
        }

        public override void ExitStringLiteral(StringLiteral stringLiteral)
        {
            stringLiteral.Type = new StringType(stringLiteral.Context);
        }

        public override void ExitArrayCreationExpression(ArrayCreationExpression arrayCreationExpression)
        {
            var subTypes = arrayCreationExpression.InitialItems.Select(x => x.Type).ToList();
            if (subTypes.Count == 0)
                arrayCreationExpression.Type = new ArrayType(arrayCreationExpression.Context, new TypeNodeWrapper(arrayCreationExpression.Context, new NullType()));
            else
            {
                IType type = null;
                for (int i = 0; i < subTypes.Count; i++)
                {
                    if (type == null || type is NullType)
                        type = subTypes[i];
                    for (int j = i + 1; j < subTypes.Count; j++)
                    {
                        if (subTypes[i].IsEquivalentTo(subTypes[j]))
                            Errors.Add(new CompilationError(arrayCreationExpression.Context, "Array must contain elements of the same types"));
                    }
                }
                if (type is ITypeNode typeNode)
                    arrayCreationExpression.Type = new ArrayType(arrayCreationExpression.Context, typeNode);
                else
                    arrayCreationExpression.Type = new ArrayType(arrayCreationExpression.Context, new TypeNodeWrapper(arrayCreationExpression.Context, type));
            }
        }

        public override void ExitArrayIndexExpression(ArrayIndexExpression arrayIndexExpression)
        {
            var baseType = arrayIndexExpression.Array.Value.Type;
            if (baseType is ArrayType arrayType)
                arrayIndexExpression.Type = arrayType.Base.Value;
            else
            {
                Errors.Add(new CompilationError(arrayIndexExpression.Context, $"Unable to index {baseType}. Type must be an array."));
                arrayIndexExpression.Type = new NullType();
            }

            if (!(arrayIndexExpression.Index.Value.Type is NumberType))
                Errors.Add(new CompilationError(arrayIndexExpression.Context, $"The index must be of type number. Got {arrayIndexExpression.Index.Value.Type}"));
        }

        public override void ExitAssignmentExpression(AssignmentExpression assignmentExpression)
        {
            var fromType = assignmentExpression.Right.Value.Type;
            var toType = assignmentExpression.Left.Value.Type;
            if (!fromType.IsAssignableTo(toType))
                Errors.Add(new CompilationError(assignmentExpression.Context, $"The type {fromType} is not assignable to {toType}"));
            assignmentExpression.Type = toType;
        }

        public override void ExitBinaryExpression(BinaryExpression binaryExpression)
        {
            var context = binaryExpression.Operator.Value.Context;
            var op = binaryExpression.Operator.Value.Text;
            switch (op)
            {
                case "||":
                case "&&":
                    if (!(binaryExpression.Left.Value.Type is BoolType))
                        Errors.Add(new CompilationError(context, $"Left side of {op} must be boolean. Found {binaryExpression.Left.Value.Type}."));
                    if (!(binaryExpression.Right.Value.Type is BoolType))
                        Errors.Add(new CompilationError(context, $"Right side of {op} must be boolean. Found {binaryExpression.Right.Value.Type}."));
                    binaryExpression.Type = new BoolType(context);
                    break;
                case "|":
                case "^":
                case "&":
                    if (!(binaryExpression.Left.Value.Type is BoolType || binaryExpression.Left.Value.Type is NumberType))
                        Errors.Add(new CompilationError(context, $"Left side of {op} must be boolean or number. Found {binaryExpression.Left.Value.Type}."));
                    if (!(binaryExpression.Right.Value.Type is BoolType || binaryExpression.Right.Value.Type is NumberType))
                        Errors.Add(new CompilationError(context, $"Right side of {op} must be boolean or number. Found {binaryExpression.Right.Value.Type}."));
                    if (!binaryExpression.Left.Value.Type.IsEquivalentTo(binaryExpression.Right.Value.Type))
                        Errors.Add(new CompilationError(context, $"Left and right side of {op} must be the same type."));
                    binaryExpression.Type = binaryExpression.Left.Value.Type;
                    break;
                case "==":
                case "!=":
                    binaryExpression.Type = new BoolType(context);
                    break;
                case ">":
                case "<":
                case ">=":
                case "<=":
                    if (!(binaryExpression.Left.Value.Type is NumberType))
                        Errors.Add(new CompilationError(context, $"Left side of {op} must be a number. Found {binaryExpression.Left.Value.Type}."));
                    if (!(binaryExpression.Right.Value.Type is NumberType))
                        Errors.Add(new CompilationError(context, $"Right side of {op} must be a number. Found {binaryExpression.Right.Value.Type}."));
                    binaryExpression.Type = new BoolType(context);
                    break;
                case "<<":
                case ">>":
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                    if (!(binaryExpression.Left.Value.Type is NumberType))
                        Errors.Add(new CompilationError(context, $"Left side of {op} must be a number. Found {binaryExpression.Left.Value.Type}."));
                    if (!(binaryExpression.Right.Value.Type is NumberType))
                        Errors.Add(new CompilationError(context, $"Right side of {op} must be a number. Found {binaryExpression.Right.Value.Type}."));
                    binaryExpression.Type = new NumberType(context);
                    break;
            }
        }

        public override void ExitCastExpression(CastExpression castExpression)
        {
            castExpression.Type = castExpression.TargetType.Value;
        }

        public override void ExitLambdaExpression(LambdaExpression lambdaExpression)
        {
            IType returnType;
            if (lambdaExpression.ExpressionBody.Value != null)
                returnType = lambdaExpression.ExpressionBody.Value.Type;
            else
            {
                var returnTypes = lambdaExpression.Block.Value
                    .AllDescendantsAndSelf()
                    .OfType<ReturnStatement>()
                    .Where(x => x.NearestAncestorOfType<LambdaExpression>() == lambdaExpression)
                    .Select(x => x.Value.Value == null ? new VoidType(x.Context) : x.Value.Value.Type)
                    .ToList();
                returnType = new VoidType(lambdaExpression.Context);
                for (int i = 0; i < returnTypes.Count; i++)
                {
                    if (returnType is VoidType || returnType is NullType)
                        returnType = returnTypes[i];
                    for (int j = i + 1; j < returnTypes.Count; j++)
                    {
                        if (returnTypes[i].IsEquivalentTo(returnTypes[j]))
                            Errors.Add(new CompilationError(lambdaExpression.Context, "All return statements of a function must return the same type"));
                    }
                }
            }

            lambdaExpression.Type = new AnonymousMethodType(lambdaExpression, returnType);
        }

        public override void ExitMemberExpression(MemberExpression memberExpression)
        {
            switch (memberExpression.Base.Value.Type)
            {
                case StaticReference staticReference:
                    if (staticReference.Declaration is EnumDeclaration enumDeclaration)
                    {
                        memberExpression.Type = new ReferenceType(memberExpression.Context, enumDeclaration);
                        return;
                    }
                    var matchingDeclarations = GetMatchingDeclarations(staticReference.Declaration, memberExpression.Name);
                    if (matchingDeclarations.Count > 1)
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found multiple declarations matching {memberExpression.Name}"));
                    if (matchingDeclarations.Count == 0)
                    {
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found no declarations matching {memberExpression.Name}"));
                        memberExpression.Type = new NullType();
                        return;
                    }
                    if (!IsStatic(matchingDeclarations[0]))
                        Errors.Add(new CompilationError(memberExpression.Context, "Non-static declaration referenced in static context."));
                    memberExpression.Type = GetType(matchingDeclarations[0]);
                    break;
                case ReferenceType referenceType:
                    if (referenceType.Declaration is EnumDeclaration)
                    {
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found no declarations matching {memberExpression.Name}"));
                        memberExpression.Type = new NullType();
                        return;
                    }
                    //Todo: Generic type

                    matchingDeclarations = GetMatchingDeclarations(referenceType.Declaration, memberExpression.Name);
                    if (matchingDeclarations.Count > 1)
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found multiple declarations matching {memberExpression.Name}"));
                    if (matchingDeclarations.Count == 0)
                    {
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found no declarations matching {memberExpression.Name}"));
                        memberExpression.Type = new NullType();
                        return;
                    }
                    if (IsStatic(matchingDeclarations[0]))
                        Errors.Add(new CompilationError(memberExpression.Context, "Static declaration referenced in non-static context."));
                    memberExpression.Type = GetType(matchingDeclarations[0]);
                    break;
                case PartialNativeMethodType partialNative:
                    var matchingNatives = partialNative.MatchingDeclarations
                        .Where(x => x.TypescriptNames.Count > partialNative.MatchingParts 
                                    && x.TypescriptNames[partialNative.MatchingParts] == memberExpression.Name)
                        .ToList();
                    if (matchingNatives.Exists(x => x.TypescriptNames.Count == partialNative.MatchingParts + 1))
                    {
                        if (matchingNatives.Count > 1)
                            Errors.Add(new CompilationError(memberExpression.Context, $"Found multiple native declarations matching '{memberExpression.Name}'"));
                        memberExpression.Type = new NativeMethodType(matchingNatives.First(x => x.TypescriptNames.Count == partialNative.MatchingParts + 1));
                        return;
                    }

                    if (matchingNatives.Count > 0)
                    {
                        memberExpression.Type = new PartialNativeMethodType(matchingNatives, partialNative.MatchingParts + 1);
                        return;
                    }
                    break;
                default:
                    Errors.Add(new CompilationError(memberExpression.Context, $"Found no declarations matching {memberExpression.Name}"));
                    memberExpression.Type = new NullType();
                    return;
            }
        }

        public override void ExitMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression)
        {
            //Todo: Lambda expressions
            switch (methodInvocationExpression.Base.Value.Type)
            {
                case MethodReferenceType methodReference:
                    if (methodInvocationExpression.GenericTypes.Count != methodReference.Declaration.GenericTypeDeclarations.Count)
                        Errors.Add(new CompilationError(methodInvocationExpression.Context, $"Target method has {methodReference.Declaration.GenericTypeDeclarations.Count} generic variables, but is invoked with {methodInvocationExpression.GenericTypes.Count}"));


                    var defaultParametersCount = methodReference.Declaration.Parameters.Count(x => x.InitExpression.Value != null);
                    if (methodInvocationExpression.Arguments.Count < methodReference.Declaration.Parameters.Count - defaultParametersCount
                        || methodInvocationExpression.Arguments.Count > methodReference.Declaration.Parameters.Count)
                        Errors.Add(new CompilationError(methodInvocationExpression.Context, $"Target method has {methodReference.Declaration.Parameters.Count} parameters, but is invoked with {methodInvocationExpression.Arguments.Count}"));
                    else
                    {
                        for (int i = 0; i < methodInvocationExpression.Arguments.Count; i++)
                        {
                            var fromType = methodInvocationExpression.Arguments[i].Type;
                            var toType = methodReference.Declaration.Parameters[i].Type.Value;
                            if (!fromType.IsAssignableTo(toType))
                                Errors.Add(new CompilationError(methodInvocationExpression.Arguments[i].Context, $"Can not assign {fromType} to {toType}"));
                        }
                    }

                    methodInvocationExpression.Type = methodReference.Declaration.ReturnType.Value;
                    if (methodReference.Declaration.ReturnType.Value is ReferenceType referenceType && referenceType.Declaration is GenericTypeDeclaration genericDeclaration)
                    {
                        var genericDeclarationIndex = methodReference.Declaration.GenericTypeDeclarations.IndexOf(genericDeclaration);
                        if (methodInvocationExpression.GenericTypes.Count > genericDeclarationIndex)
                            methodInvocationExpression.Type = methodInvocationExpression.GenericTypes[genericDeclarationIndex];
                        else
                            methodInvocationExpression.Type = new NullType();
                    }
                    break;
                case NativeMethodType nativeMethod:
                    if (methodInvocationExpression.GenericTypes.Count != 0)
                        Errors.Add(new CompilationError(methodInvocationExpression.Context, $"Target method has 0 generic variables, but is invoked with {methodInvocationExpression.GenericTypes.Count}"));


                    if (methodInvocationExpression.Arguments.Count != nativeMethod.MatchingDeclaration.ParameterTypes.Count)
                        Errors.Add(new CompilationError(methodInvocationExpression.Context, $"Target method has {nativeMethod.MatchingDeclaration.ParameterTypes.Count} parameters, but is invoked with {methodInvocationExpression.Arguments.Count}"));
                    else
                    {
                        for (int i = 0; i < methodInvocationExpression.Arguments.Count; i++)
                        {
                            var fromType = methodInvocationExpression.Arguments[i].Type;
                            var toType = nativeMethod.MatchingDeclaration.ParameterTypes[i];
                            if (!fromType.IsAssignableTo(toType))
                                Errors.Add(new CompilationError(methodInvocationExpression.Arguments[i].Context, $"Can not assign {fromType} to {toType}"));
                        }
                    }

                    methodInvocationExpression.Type = nativeMethod.MatchingDeclaration.ReturnType;
                    break;
                default:
                    Errors.Add(new CompilationError(methodInvocationExpression.Context, $"Base type '{methodInvocationExpression.Base.Value.Type}' is not a method"));
                    methodInvocationExpression.Type = new NullType();
                    break;
            }

        }

        public override void ExitObjectCreationExpression(ObjectCreationExpression objectCreationExpression)
        {
            if (!(objectCreationExpression.CreatedType.Value is ReferenceType referenceType) || !(referenceType.Declaration is ClassDeclaration))
                Errors.Add(new CompilationError(objectCreationExpression.Context, $"{objectCreationExpression.CreatedType.Value} is not a class. You can not use new."));
            objectCreationExpression.Type = objectCreationExpression.CreatedType.Value;
        }

        public override void ExitPosfixOperationExpression(PosfixOperationExpression posfixOperationExpression)
        {
            var baseType = posfixOperationExpression.Base.Value.Type;
            var op = posfixOperationExpression.Operation.Value.Text;
            if (!(baseType is NumberType))
                Errors.Add(new CompilationError(posfixOperationExpression.Context, $"{op} can only be applied to a number. Found {baseType}."));
            posfixOperationExpression.Type = new NumberType(posfixOperationExpression.Context);
        }

        public override void ExitThisExpression(ThisExpression thisExpression)
        {
            var classDeclaration = thisExpression.NearestAncestorOfType<ClassDeclaration>();
            if (classDeclaration == null)
            {
                Errors.Add(new CompilationError(thisExpression.Context, "The this keyword can only be used inside classes"));
                thisExpression.Type = new NullType();
            }
            else
            {
                thisExpression.Type = new ReferenceType(thisExpression.Context, Enumerable.Empty<Token>())
                {
                    Declaration = classDeclaration
                };
            }   
        }

        public override void ExitUnaryExpression(UnaryExpression unaryExpression)
        {
            var baseType = unaryExpression.Base.Value.Type;
            var op = unaryExpression.Operator.Value.Text;
            if (op == "!")
            {
                if (!(baseType is BoolType))
                    Errors.Add(new CompilationError(unaryExpression.Context, $"{op} can only be applied to a boolean. Found {baseType}."));
                unaryExpression.Type = new BoolType(unaryExpression.Context);
            }
            else
            {
                if (!(baseType is NumberType))
                    Errors.Add(new CompilationError(unaryExpression.Context, $"{op} can only be applied to a number. Found {baseType}."));
                unaryExpression.Type = new NumberType(unaryExpression.Context);
            }
        }

        public override void ExitReturnStatement(ReturnStatement returnStatement)
        {
            var method = returnStatement.NearestAncestorOfAnyType(typeof(MethodDeclaration), typeof(LambdaExpression));
            if (method is MethodDeclaration methodDeclaration)
            {
                var returnStatementType = returnStatement.Value.Value?.Type ?? new VoidType(returnStatement.Context);
                if (!returnStatementType.IsAssignableTo(methodDeclaration.ReturnType.Value))
                    Errors.Add(new CompilationError(returnStatement.Context, $"{returnStatementType} is not assignable to the return type of the method: {methodDeclaration.ReturnType.Value}."));
            }
        }

        public override void ExitForeachStatement(ForeachStatement foreachStatement)
        {
            if (!(foreachStatement.List.Value.Type is ArrayType))
                Errors.Add(new CompilationError(foreachStatement.Context, $"Can not iterate over {foreachStatement.List.Value.Type}."));
        }

        public override void ExitForStatement(ForStatement forStatement)
        {
            if (forStatement.Condition.Value != null && !(forStatement.Condition.Value.Type is BoolType))
                Errors.Add(new CompilationError(forStatement.Context, $"The condition must be a boolean, found {forStatement.Condition.Value.Type}."));
        }

        public override void ExitIfStatement(IfStatement ifStatement)
        {
            if (!(ifStatement.Condition.Value.Type is BoolType))
                Errors.Add(new CompilationError(ifStatement.Context, $"The condition must be a boolean, found {ifStatement.Condition.Value.Type}."));
        }

        public override void ExitVariableDeclaration(VariableDeclaration variableDeclaration)
        {
            if (variableDeclaration.InitExpression.Value == null && variableDeclaration.Type.Value == null)
                Errors.Add(new CompilationError(variableDeclaration.Context, "You must specify a type, or initialize the variable."));
            else if (variableDeclaration.InitExpression.Value != null && variableDeclaration.Type.Value != null && !variableDeclaration.InitExpression.Value.Type.IsAssignableTo(variableDeclaration.Type.Value))
                Errors.Add(new CompilationError(variableDeclaration.Context, $"{variableDeclaration.InitExpression.Value.Type} is not assignable to {variableDeclaration.Type}."));
            else if (variableDeclaration.InitExpression.Value != null && variableDeclaration.Type.Value == null)
                variableDeclaration.Type.Value = variableDeclaration.InitExpression.Value.Type as ITypeNode ?? new TypeNodeWrapper(variableDeclaration.Context, variableDeclaration.InitExpression.Value.Type);
        }

        public override void ExitNativeMethodInvocationExpression(NativeMethodInvocationExpression nativeMethodInvocationExpression)
        {
            for (int i = 0; i < nativeMethodInvocationExpression.Arguments.Count; i++)
            {
                var fromType = nativeMethodInvocationExpression.Arguments[i].Type;
                var toType = nativeMethodInvocationExpression.ParameterTypes[i];
                if (!fromType.IsAssignableTo(toType))
                    Errors.Add(new CompilationError(nativeMethodInvocationExpression.Arguments[i].Context, $"Can not assign {fromType} to {toType}"));
            }
        }

        public override void ExitRuleDeclaration(RuleDeclaration ruleDeclaration)
        {
            //Todo: Type check trigger
            var conditionType = new FunctionType(ruleDeclaration.Context, new VariableDeclaration[0], new BoolType(ruleDeclaration.Context));
            var actionType = new FunctionType(ruleDeclaration.Context, new VariableDeclaration[0], new VoidType(ruleDeclaration.Context));
            if (ruleDeclaration.Condition.Value != null && !ruleDeclaration.Condition.Value.Type.IsAssignableTo(conditionType))
                Errors.Add(new CompilationError(ruleDeclaration.Condition.Value.Context, $"Can not assign {ruleDeclaration.Condition.Value.Type} to {conditionType}"));
            if (!ruleDeclaration.Action.Value.Type.IsAssignableTo(actionType))
                Errors.Add(new CompilationError(ruleDeclaration.Action.Value.Context, $"Can not assign {ruleDeclaration.Action.Value.Type} to {actionType}"));
        }
    }
}