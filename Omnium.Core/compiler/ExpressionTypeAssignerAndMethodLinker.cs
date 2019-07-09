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
using Omnium.Core.extensions;

namespace Omnium.Core.compiler
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
                if (declarations.Count > 1)
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
                    matchingDeclarations.AddRange(importedSourceFile.ImportedModules.Where(x => x.Name == name));
                    matchingDeclarations.AddRange(importedSourceFile.ImportedClasses.Where(x => x.Name == name).DistinctBy(x => x.Name));
                    matchingDeclarations.AddRange(importedSourceFile.ImportedEnums.Where(x => x.Name == name));
                    matchingDeclarations.AddRange(importedSourceFile.ImportedMethods.Where(x => x.Name == name));
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

        public override void ExitArrayIndexExpression(ArrayIndexExpression arrayIndexExpression)
        {
            if (arrayIndexExpression.Array.Type.IsList(arrayIndexExpression.NearestAncestorOfType<Root>()))
                arrayIndexExpression.Type = ((GenericType)arrayIndexExpression.Array.Type).GenericTypes.Single();
            else
            {
                Errors.Add(new CompilationError(arrayIndexExpression.Context, $"Unable to index {arrayIndexExpression.Array.Type}. Type must be an array."));
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

        public override void ExitAssertion(Assertion assertion)
        {
            if (!assertion.Condition.Type.IsAssignableTo(new BoolType(assertion.Context)))
            {
                Errors.Add(new CompilationError(assertion.Context, $"The type {assertion.Condition.Type} is not assignable to boolean"));
            }
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
            ExitMemberExpression(memberExpression, memberExpression.Base.Type);
        }
        public void ExitMemberExpression(MemberExpression memberExpression, IType baseType)
        {
            switch (baseType)
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
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found multiple declarations on {memberExpression.Base.Type} matching {memberExpression.Name}"));
                    if (!matchingDeclarations.Any())
                    {
                        throw new CompilationError(memberExpression.Context, $"Found no on {memberExpression.Base.Type} declarations matching {memberExpression.Name}");
                    }
                    if (!IsStatic(matchingDeclarations[0]))
                        Errors.Add(new CompilationError(memberExpression.Context, "Non-static declaration referenced in static context."));
                    memberExpression.Type = GetType(matchingDeclarations[0]);
                    memberExpression.Declaration = matchingDeclarations[0];

                    break;
                case GenericType genericType:
                    if (genericType.IsList(memberExpression.NearestAncestorOfType<Root>()) && memberExpression.Name == "length")
                    {
                        var nativeArrayCount = NativeMethods.ArrayCount(memberExpression.Context, memberExpression.Base);
                        memberExpression.ReplaceWith(nativeArrayCount);
                        break;
                    }
                    ExitMemberExpression(memberExpression, genericType.Base);
                    return;
                case ReferenceType referenceType:
                    if (referenceType.Declaration is EnumDeclaration)
                    {
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found no declarations on {memberExpression.Base.Type} matching {memberExpression.Name}"));
                        memberExpression.Type = new NullType();
                        return;
                    }
                    matchingDeclarations = GetMatchingDeclarations(referenceType.Declaration, memberExpression, memberExpression.Name);
                    if (matchingDeclarations.Count() > 1)
                        Errors.Add(new CompilationError(memberExpression.Context, $"Found multiple declarations on {memberExpression.Base.Type} matching {memberExpression.Name}"));
                    if (matchingDeclarations.Count == 0)
                    {
                        throw new CompilationError(memberExpression.Context, $"Found no declarations on {memberExpression.Base.Type} matching {memberExpression.Name}");
                    }
                    if (IsStatic(matchingDeclarations[0]))
                        Errors.Add(new CompilationError(memberExpression.Context, "Static declaration referenced in non-static context."));
                    memberExpression.Type = GetType(matchingDeclarations[0]);
                    memberExpression.Declaration = matchingDeclarations[0];
                    break;
                default:
                    throw new CompilationError(memberExpression.Context, $"Found no declarations on {memberExpression.Base.Type} matching {memberExpression.Name}");
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

        public override void EnterForeachStatement(ForeachStatement foreachStatement)
        {
            Visit(foreachStatement.List);
            if (!foreachStatement.List.Type.IsList(foreachStatement.NearestAncestorOfType<Root>()))
            {
                Errors.Add(new CompilationError(foreachStatement.Context, $"Can not iterate over {foreachStatement.List.Type}."));
                skipChildren = true;
                return;
            }

            var genericType = (GenericType)foreachStatement.List.Type;

            foreachStatement.Variable.AddChild(AstCloner.Clone(genericType.GenericTypes.Single()));
            Visit(foreachStatement.Body);
            skipChildren = true;
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
                            var toType = ReplaceGenerics(methodInvocationExpression, parameters[i].Type);
                            if (!fromType.IsAssignableTo(toType))
                                Errors.Add(new CompilationError(arguments[i].Context, $"Can not assign {fromType} to {toType}"));
                        }
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

        private ITypeNode ReplaceGenerics(MethodInvocationExpression methodInvocationExpression, ITypeNode type)
        {
            var clone = AstCloner.Clone(type);
            foreach (var referenceType in clone.AllDescendantsAndSelf().OfType<ReferenceType>().ToList())
            {
                if (!(referenceType.Declaration is GenericTypeDeclaration genericTargetDeclaration))
                    continue;
                if (methodInvocationExpression.IsDescendantOf(genericTargetDeclaration.Parent))
                    continue;
                List<GenericTypeDeclaration> genericList;
                List<ITypeNode> typeList;
                switch (genericTargetDeclaration.Parent)
                {
                    case MethodDeclaration method:
                        genericList = method.GenericTypeDeclarations.ToList();
                        typeList = methodInvocationExpression.GenericTypes.ToList();
                        break;
                    case ClassDeclaration classDeclaration:
                        genericList = classDeclaration.GenericTypeDeclarations.ToList();
                        if (!(methodInvocationExpression.Base is MemberExpression memberExpression
                              && memberExpression.Base.Type is GenericType genericType))
                            throw new CompilationError(methodInvocationExpression.Context, "Expected generic type parameters");
                        typeList = genericType.GenericTypes.ToList();
                        break;
                    default:
                        throw new Exception("Unexpected method parent: " + genericTargetDeclaration.Parent);
                }

                if (genericList.Count != typeList.Count)
                    throw new CompilationError(methodInvocationExpression.Context, $"Expected {genericList.Count} generic type parameters, but got {typeList}");
                var index = genericList.IndexOf(genericTargetDeclaration);
                var replacement = AstCloner.Clone(typeList[index]);
                if (referenceType.Parent == null)
                    clone = replacement;
                else
                    referenceType.ReplaceWith(replacement);
            }

            return clone;
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
            else if (classDeclaration.GenericTypeDeclarations.Any())
            {
                thisExpression.Type = new GenericType(thisExpression.Context,
                    ReferenceToType(thisExpression.Context, classDeclaration).Yield()
                        .Concat(classDeclaration.GenericTypeDeclarations.Select(x => ReferenceToType(thisExpression.Context, x)))
                );
            }
            else
            {
                thisExpression.Type = ReferenceToType(thisExpression.Context, classDeclaration);
            }
        }

        private ReferenceType ReferenceToType(IParseTree context, INode declaration)
        {
            return new ReferenceType(context, Enumerable.Empty<Token>())
            {
                Declaration = declaration
            };
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
            if (!foreachStatement.List.Type.IsList(foreachStatement.NearestAncestorOfType<Root>()))
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
                .Where(x => x.Name == "Rule")
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
                .Where(x => x.Name == "Rule")
                .SelectMany(x => x.ClassDeclarations)
                .Single(x => x.Name == "Event");
            nativeTrigger.Type = new ReferenceType(nativeTrigger.Context, eventDeclaration);
        }
    }
}