using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler.step2TypeAssignment.expressionTypeAssignerAndMethodLinker
{
    public partial class ExpressionTypeAssignerAndMethodLinker : TreeVoidWalker
    {

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

        public override void ExitChaseExpression(ChaseExpression chaseExpression)
        {
            if (!(chaseExpression.VariableReference.Declaration is VariableDeclaration))
                Errors.Add(new CompilationError(chaseExpression.Context, "The first argument must be a variable."));
            if (!chaseExpression.VariableReference.Type.IsEquivalentTo(chaseExpression.Destination.Type))
                Errors.Add(new CompilationError(chaseExpression.Context, "Variable and destination must be of same types"));
            chaseExpression.Type = new VoidType(chaseExpression.Context);
        }

        public override void ExitStopChaseExpression(StopChaseExpression stopChaseExpression)
        {
            if (!(stopChaseExpression.VariableReference.Declaration is VariableDeclaration))
                Errors.Add(new CompilationError(stopChaseExpression.Context, "The first argument must be a variable."));
            stopChaseExpression.Type = new VoidType(stopChaseExpression.Context);
        }

        public override void ExitPlayerVarsExpression(PlayerVarsExpression playerVarsExpression)
        {
            playerVarsExpression.Type = playerVarsExpression.ReturnType;
        }

        public override void ExitPlayerVarsPlayerExpression(PlayerVarsPlayerExpression playerVarsPlayerExpression)
        {
            var playerClass = playerVarsPlayerExpression.NearestAncestorOfType<Root>().SourceFiles.SelectMany(x => x.ClassDeclarations)
                .Where(x => x.Name == "Player").ToList();

            if (playerClass.Count > 1)
                throw new CompilationError(playerClass.First().Context, "The class 'Player' can not be duplicated");
            playerVarsPlayerExpression.Type = new ReferenceType(playerVarsPlayerExpression.Context, playerClass.First());
        }
    }
}