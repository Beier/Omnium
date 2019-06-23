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
using OverwatchCompiler.ToWorkshop.extensions;

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
                typeof(SourceFile),
                typeof(Root));

            foreach (var ancestor in ancestors)
            {
                var declarations = GetMatchingDeclarations(ancestor, simpleNameExpression, simpleNameExpression.Name);
                if (!declarations.Any())
                    continue;
                if (declarations.Count() > 1)
                    Errors.Add(new CompilationError(simpleNameExpression.Context, $"Found multiple declarations matching '{simpleNameExpression.Name}'"));

                simpleNameExpression.Declaration = declarations.First();
                simpleNameExpression.Type = GetType(simpleNameExpression.Declaration);

                if (simpleNameExpression.Declaration is GetterSetterDeclaration getterSetterDeclaration)
                {
                    if (simpleNameExpression.Parent is AssignmentExpression assignmentExpression && simpleNameExpression == assignmentExpression.Left)
                    {
                        if (getterSetterDeclaration.Setter == null)
                            Errors.Add(new CompilationError(simpleNameExpression.Context, $"{getterSetterDeclaration.Name} has no setter."));
                        else
                            simpleNameExpression.Declaration = getterSetterDeclaration.Setter;
                        if (assignmentExpression.Operator.Value != "=" && getterSetterDeclaration.Getter == null)
                            Errors.Add(new CompilationError(simpleNameExpression.Context, $"{getterSetterDeclaration.Name} has no getter."));
                    }
                    else
                    {
                        if (getterSetterDeclaration.Getter == null)
                            Errors.Add(new CompilationError(simpleNameExpression.Context, $"{getterSetterDeclaration.Name} has no getter."));
                        else
                            simpleNameExpression.Declaration = getterSetterDeclaration.Getter;
                    }
                }
                return;
            }
            throw new CompilationError(simpleNameExpression.Context, $"Found no declarations matching '{simpleNameExpression.Name}'");
        }

        private static List<INamedDeclaration> GetMatchingDeclarations(INode ancestor, INode source, string name)
        {
            var matchingDeclarations = new List<INamedDeclaration>();

            if (ancestor is ClassDeclaration classDeclaration)
            {
                var visibleClasses = classDeclaration.EquivalentClassDeclarations.Where(x => x.IsVisibleFrom(source)).ToList();
                matchingDeclarations.AddRange(visibleClasses.SelectMany(x => x.GettersAndSetters).Where(x => x.Name == name));
                matchingDeclarations.AddRange(visibleClasses.SelectMany(x => x.MethodDeclarations).Where(x => x.Name == name));
                matchingDeclarations.AddRange(visibleClasses.SelectMany(x => x.Variables).Where(x => x.Name == name));
            }
            else if (ancestor is IHasVariables variableContainer)
            {
                matchingDeclarations.AddRange(variableContainer.Variables.Where(x => x.Name == name));
            }

            if (ancestor is AbstractTopLevelNode topLevelNode)
            {
                matchingDeclarations.AddRange(topLevelNode.ModuleDeclarations.Where(x => x.Name == name));
                matchingDeclarations.AddRange(topLevelNode.ClassDeclarations.Where(x => x.Name == name).DistinctBy(x => x.Name));
                matchingDeclarations.AddRange(topLevelNode.EnumDeclarations.Where(x => x.Name == name));
                matchingDeclarations.AddRange(topLevelNode.MethodDeclarations.Where(x => x.Name == name));
            }

            if (ancestor is SourceFile sourceFile)
            {
                foreach (var importedSourceFile in sourceFile.ImportedSourceFiles)
                {
                    matchingDeclarations.AddRange(importedSourceFile.ModuleDeclarations.Where(x => x.Name == name));
                    matchingDeclarations.AddRange(importedSourceFile.ClassDeclarations.Where(x => x.Name == name).DistinctBy(x => x.Name));
                    matchingDeclarations.AddRange(importedSourceFile.EnumDeclarations.Where(x => x.Name == name));
                }
            }

            if (ancestor is Root root)
            {
                matchingDeclarations.AddRange(root.NativeModules.Where(x => x.Name == name));
                matchingDeclarations.AddRange(root.NativeMethods.Where(x => x.Name == name));
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
                    return variableDeclaration.Type;
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
            nullLiteral.Type = new NullType();
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
            if (!subTypes.Any())
                arrayCreationExpression.Type = new ArrayType(arrayCreationExpression.Context, new NullType().Wrap(arrayCreationExpression.Context));
            else
            {
                IType type = null;
                for (int i = 0; i < subTypes.Count(); i++)
                {
                    if (type == null || type is NullType)
                        type = subTypes[i];
                    for (int j = i + 1; j < subTypes.Count(); j++)
                    {
                        if (subTypes[i].IsEquivalentTo(subTypes[j]))
                            Errors.Add(new CompilationError(arrayCreationExpression.Context, "Array must contain elements of the same types"));
                    }
                }

                arrayCreationExpression.Type = new ArrayType(arrayCreationExpression.Context, type.Wrap(arrayCreationExpression.Context));
            }
        }

        public override void ExitArrayIndexExpression(ArrayIndexExpression arrayIndexExpression)
        {
            var baseType = arrayIndexExpression.Array.Type;
            if (baseType is ArrayType arrayType)
                arrayIndexExpression.Type = arrayType.Base;
            else
            {
                Errors.Add(new CompilationError(arrayIndexExpression.Context, $"Unable to index {baseType}. Type must be an array."));
                arrayIndexExpression.Type = new NullType();
            }

            if (!(arrayIndexExpression.Index.Type is NumberType))
                Errors.Add(new CompilationError(arrayIndexExpression.Context, $"The index must be of type number. Got {arrayIndexExpression.Index.Type}"));
        }

        public override void ExitAssignmentExpression(AssignmentExpression assignmentExpression)
        {
            var fromType = assignmentExpression.Right.Type;
            var toType = assignmentExpression.Left.Type;
            if (!fromType.IsAssignableTo(toType))
                Errors.Add(new CompilationError(assignmentExpression.Context, $"The type {fromType} is not assignable to {toType}"));
            assignmentExpression.Type = toType;
        }

        public override void ExitBinaryExpression(BinaryExpression binaryExpression)
        {
            var context = binaryExpression.Operator.Context;
            var op = binaryExpression.Operator.Text;
            switch (op)
            {
                case "||":
                case "&&":
                    if (!(binaryExpression.Left.Type is BoolType))
                        Errors.Add(new CompilationError(context, $"Left side of {op} must be boolean. Found {binaryExpression.Left.Type}."));
                    if (!(binaryExpression.Right.Type is BoolType))
                        Errors.Add(new CompilationError(context, $"Right side of {op} must be boolean. Found {binaryExpression.Right.Type}."));
                    binaryExpression.Type = new BoolType(context);
                    break;
                case "|":
                case "^":
                case "&":
                    if (!(binaryExpression.Left.Type is BoolType || binaryExpression.Left.Type is NumberType))
                        Errors.Add(new CompilationError(context, $"Left side of {op} must be boolean or number. Found {binaryExpression.Left.Type}."));
                    if (!(binaryExpression.Right.Type is BoolType || binaryExpression.Right.Type is NumberType))
                        Errors.Add(new CompilationError(context, $"Right side of {op} must be boolean or number. Found {binaryExpression.Right.Type}."));
                    if (!binaryExpression.Left.Type.IsEquivalentTo(binaryExpression.Right.Type))
                        Errors.Add(new CompilationError(context, $"Left and right side of {op} must be the same type."));
                    binaryExpression.Type = binaryExpression.Left.Type;
                    break;
                case "==":
                case "!=":
                    binaryExpression.Type = new BoolType(context);
                    break;
                case ">":
                case "<":
                case ">=":
                case "<=":
                    if (!(binaryExpression.Left.Type is NumberType))
                        Errors.Add(new CompilationError(context, $"Left side of {op} must be a number. Found {binaryExpression.Left.Type}."));
                    if (!(binaryExpression.Right.Type is NumberType))
                        Errors.Add(new CompilationError(context, $"Right side of {op} must be a number. Found {binaryExpression.Right.Type}."));
                    binaryExpression.Type = new BoolType(context);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                    if (op == "+" && (binaryExpression.Left.Type is StringType || binaryExpression.Right.Type is StringType))
                    {
                        binaryExpression.Type = new StringType(context);
                        break;
                    }
                    if (IsVector(binaryExpression.Left.Type) && IsVector(binaryExpression.Right.Type))
                    {
                        binaryExpression.Type = binaryExpression.Left.Type;
                        break;
                    }
                    if (binaryExpression.Left.Type is NumberType && binaryExpression.Right.Type is NumberType)
                    {
                        binaryExpression.Type = new NumberType(context);
                        break;
                    }
                    if (op == "*"
                        && (IsVector(binaryExpression.Left.Type) && binaryExpression.Right.Type is NumberType
                            || binaryExpression.Left.Type is NumberType && IsVector(binaryExpression.Right.Type)))
                    {
                        binaryExpression.Type = IsVector(binaryExpression.Left.Type) ? binaryExpression.Left.Type : binaryExpression.Right.Type;
                        break;
                    }
                    if (op == "/" && IsVector(binaryExpression.Left.Type) && binaryExpression.Right.Type is NumberType)
                    {
                        binaryExpression.Type = binaryExpression.Left.Type;
                        break;
                    }

                    Errors.Add(new CompilationError(context, $"{op} is not defined between {binaryExpression.Left.Type} and {binaryExpression.Right.Type}."));
                    binaryExpression.Type = binaryExpression.Left.Type;
                    break;
            }
        }

        private bool IsVector(IType type)
        {
            return type is ReferenceType referenceType
                   && referenceType.Declaration is ClassDeclaration classDeclaration
                   && classDeclaration.Name == "Vector";
        }

        public override void ExitCastExpression(CastExpression castExpression)
        {
            castExpression.Type = castExpression.TargetType;
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

        public override void ExitMemberExpression(MemberExpression memberExpression)
        {
            switch (memberExpression.Base.Type)
            {
                case StaticReference staticReference:
                    if (staticReference.Declaration is EnumDeclaration enumDeclaration)
                    {
                        memberExpression.Declaration = enumDeclaration.Values.SingleOrDefault(x => x.Name == memberExpression.Name);
                        memberExpression.Type = new ReferenceType(memberExpression.Context, enumDeclaration);
                        if (memberExpression.Declaration == null)
                            Errors.Add(new CompilationError(memberExpression.Context, $"Enum {enumDeclaration.Name} does not contain a member called {memberExpression.Name}"));
                        return;
                    }
                    var matchingDeclarations = GetMatchingDeclarations(staticReference.Declaration, memberExpression, memberExpression.Name);
                    if (matchingDeclarations.Count() > 1)
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found multiple declarations matching {memberExpression.Name}"));
                    if (!matchingDeclarations.Any())
                    {
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found no declarations matching {memberExpression.Name}"));
                        memberExpression.Type = new NullType();
                        return;
                    }
                    if (!IsStatic(matchingDeclarations[0]))
                        Errors.Add(new CompilationError(memberExpression.Context, "Non-static declaration referenced in static context."));
                    memberExpression.Type = GetType(matchingDeclarations[0]);
                    memberExpression.Declaration = matchingDeclarations[0];

                    break;
                case ReferenceType referenceType:
                    if (referenceType.Declaration is EnumDeclaration)
                    {
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found no declarations matching {memberExpression.Name}"));
                        memberExpression.Type = new NullType();
                        return;
                    }
                    matchingDeclarations = GetMatchingDeclarations(referenceType.Declaration, memberExpression, memberExpression.Name);
                    if (matchingDeclarations.Count() > 1)
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
                    memberExpression.Declaration = matchingDeclarations[0];
                    break;
                default:
                    Errors.Add(new CompilationError(memberExpression.Context, $"Found no declarations matching {memberExpression.Name}"));
                    memberExpression.Type = new NullType();
                    return;
            }
            
            if (memberExpression.Declaration is GetterSetterDeclaration getterSetterDeclaration)
            {
                if (memberExpression.Parent is AssignmentExpression assignmentExpression && memberExpression == assignmentExpression.Left)
                {
                    if (getterSetterDeclaration.Setter == null)
                        Errors.Add(new CompilationError(memberExpression.Context, $"{getterSetterDeclaration.Name} has no setter."));
                    else
                        memberExpression.Declaration = getterSetterDeclaration.Setter;
                    if (assignmentExpression.Operator.Value != "=" && getterSetterDeclaration.Getter == null)
                        Errors.Add(new CompilationError(memberExpression.Context, $"{getterSetterDeclaration.Name} has no getter."));
                }
                else
                {
                    if (getterSetterDeclaration.Getter == null)
                        Errors.Add(new CompilationError(memberExpression.Context, $"{getterSetterDeclaration.Name} has no getter."));
                    else
                        memberExpression.Declaration = getterSetterDeclaration.Getter;
                }
            }
        }

        public override void EnterMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression)
        {
            if (methodInvocationExpression.Base is MemberExpression memberExpression
                && memberExpression.Name == "toString")
            {
                if (methodInvocationExpression.GenericTypes.Any())
                    Errors.Add(new CompilationError(memberExpression.Context, "Expected 0 generic type arguments"));
                if (methodInvocationExpression.Arguments.Any())
                    Errors.Add(new CompilationError(memberExpression.Context, "Expected 0 arguments"));
                var replacement = memberExpression.Base;
                methodInvocationExpression.ReplaceWith(replacement);
                Visit(replacement);
                replacement.Type = new StringType(methodInvocationExpression.Context);
                skipChildren = true;
            }
        }

        public override void ExitMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression)
        {
            if (methodInvocationExpression.Parent == null)
                return;
            switch (methodInvocationExpression.Base.Type)
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
                            var toType = parameters[i].Type;
                            if (!fromType.IsAssignableTo(toType))
                                Errors.Add(new CompilationError(arguments[i].Context, $"Can not assign {fromType} to {toType}"));
                        }
                    }

                    methodInvocationExpression.Type = methodReference.Declaration.ReturnType;
                    if (methodReference.Declaration.ReturnType is ReferenceType referenceType && referenceType.Declaration is GenericTypeDeclaration genericDeclaration)
                    {
                        var genericDeclarationIndex = methodReference.Declaration.GenericTypeDeclarations.IndexOf(genericDeclaration);
                        if (methodInvocationExpression.GenericTypes.Count() > genericDeclarationIndex)
                            methodInvocationExpression.Type = methodInvocationExpression.GenericTypes.AtIndex(genericDeclarationIndex);
                        else
                            methodInvocationExpression.Type = new NullType();
                    }
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

        public override void ExitObjectCreationExpression(ObjectCreationExpression objectCreationExpression)
        {
            Errors.Add(new CompilationError(objectCreationExpression.Context, "It is not possible to create new objects."));
            if (!(objectCreationExpression.CreatedType is ReferenceType referenceType) || !(referenceType.Declaration is ClassDeclaration))
                Errors.Add(new CompilationError(objectCreationExpression.Context, $"{objectCreationExpression.CreatedType} is not a class. You can not use new."));
            objectCreationExpression.Type = objectCreationExpression.CreatedType;
        }

        public override void ExitPosfixOperationExpression(PosfixOperationExpression posfixOperationExpression)
        {
            var baseType = posfixOperationExpression.Base.Type;
            var op = posfixOperationExpression.Operation.Text;
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
            var baseType = unaryExpression.Base.Type;
            var op = unaryExpression.Operator.Text;
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
                var returnStatementType = returnStatement?.Value.Type ?? new VoidType(returnStatement.Context);
                if (!returnStatementType.IsAssignableTo(methodDeclaration.ReturnType))
                    Errors.Add(new CompilationError(returnStatement.Context, $"{returnStatementType} is not assignable to the return type of the method: {methodDeclaration.ReturnType}."));
            }
        }

        public override void ExitForeachStatement(ForeachStatement foreachStatement)
        {
            if (!(foreachStatement.List.Type is ArrayType))
                Errors.Add(new CompilationError(foreachStatement.Context, $"Can not iterate over {foreachStatement.List.Type}."));
        }

        public override void ExitForStatement(ForStatement forStatement)
        {
            if (forStatement.Condition != null && !(forStatement.Condition.Type is BoolType))
                Errors.Add(new CompilationError(forStatement.Context, $"The condition must be a boolean, found {forStatement.Condition.Type}."));
        }

        public override void ExitIfStatement(IfStatement ifStatement)
        {
            if (!(ifStatement.Condition.Type is BoolType))
                Errors.Add(new CompilationError(ifStatement.Context, $"The condition must be a boolean, found {ifStatement.Condition.Type}."));
        }

        public override void ExitVariableDeclaration(VariableDeclaration variableDeclaration)
        {
            if (variableDeclaration.InitExpression == null && variableDeclaration.Type == null)
                Errors.Add(new CompilationError(variableDeclaration.Context, "You must specify a type, or initialize the variable."));
            else if (variableDeclaration.InitExpression != null && variableDeclaration.Type != null && !variableDeclaration.InitExpression.Type.IsAssignableTo(variableDeclaration.Type))
                Errors.Add(new CompilationError(variableDeclaration.Context, $"{variableDeclaration.InitExpression.Type} is not assignable to {variableDeclaration.Type}."));
            else if (variableDeclaration.InitExpression != null && variableDeclaration.Type == null)
                variableDeclaration.AddChild(variableDeclaration.InitExpression.Type.Wrap(variableDeclaration.Context));
        }

        public override void ExitNativeMethodInvocationExpression(NativeMethodInvocationExpression nativeMethodInvocationExpression)
        {
            var arguments = nativeMethodInvocationExpression.Arguments.ToList();
            var parameterTypes = nativeMethodInvocationExpression.ParameterTypes.ToList();
            for (int i = 0; i < nativeMethodInvocationExpression.Arguments.Count(); i++)
            {
                var fromType = arguments[i].Type;
                var toType = parameterTypes[i];
                if (!fromType.IsAssignableTo(toType))
                    Errors.Add(new CompilationError(arguments[i].Context, $"Can not assign {fromType} to {toType}"));
            }
        }

        public override void ExitRuleDeclaration(RuleDeclaration ruleDeclaration)
        {
            var root = ruleDeclaration.NearestAncestorOfType<Root>();
            var eventDeclaration = root
                .SourceFiles
                .SelectMany(x => x.ModuleDeclarations)
                .Where(x => x.Name == "Events")
                .SelectMany(x => x.ClassDeclarations)
                .Single(x => x.Name == "Event");

            var triggerType = new ReferenceType(ruleDeclaration.Context, eventDeclaration);
            var conditionType = new BoolType(ruleDeclaration.Context);
            var actionType = new FunctionType(ruleDeclaration.Context, new VoidType(ruleDeclaration.Context).Yield());
            if (!ruleDeclaration.Trigger.Type.IsAssignableTo(triggerType))
                Errors.Add(new CompilationError(ruleDeclaration.Condition.Context, $"Can not assign {ruleDeclaration.Condition.Type} to {conditionType}"));
            if (!ruleDeclaration.Condition.Type.IsAssignableTo(conditionType))
                Errors.Add(new CompilationError(ruleDeclaration.Condition.Context, $"Can not assign {ruleDeclaration.Condition.Type} to {conditionType}"));
            if (!ruleDeclaration.Action.Type.IsAssignableTo(actionType))
                Errors.Add(new CompilationError(ruleDeclaration.Action.Context, $"Can not assign {ruleDeclaration.Action.Type} to {actionType}"));
        }

        public override void ExitNativeTrigger(NativeTrigger nativeTrigger)
        {
            var root = nativeTrigger.NearestAncestorOfType<Root>();
            var eventDeclaration = root
                .SourceFiles
                .SelectMany(x => x.ModuleDeclarations)
                .Where(x => x.Name == "Events")
                .SelectMany(x => x.ClassDeclarations)
                .Single(x => x.Name == "Event");
            nativeTrigger.Type = new ReferenceType(nativeTrigger.Context, eventDeclaration);
        }
    }
}