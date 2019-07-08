using System;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.declarations;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.types
{
    public static class TypeExtensions
    {
        public static bool IsList(this IType type, Root root)
        {
            if (!(type is GenericType genericType))
                return false;
            return genericType.Base is ReferenceType referenceType && referenceType.Declaration == root.ListDeclaration;
        }

        public static ITypeNode Wrap(this IType type, IParseTree context)
        {
            if (type is ITypeNode typeNode)
                return typeNode;
            return new TypeNodeWrapper(context, type);
        }

        public static bool IsEquivalentTo(this IType type1, IType type2)
        {
            if (type1 is TypeNodeWrapper wrapper1)
                return wrapper1.Type.IsEquivalentTo(type2);
            if (type2 is TypeNodeWrapper wrapper2)
                return type1.IsEquivalentTo(wrapper2.Type);
            if (type1 is VoidType || type2 is VoidType)
                return type1 is VoidType && type2 is VoidType;
            if (type1 is NullType || type2 is NullType)
                return true;
            if (type1.GetType() != type2.GetType())
                return false;
            switch (type1)
            {
                case FunctionType _:
                    return type1 == type2;
                case MethodReferenceType _:
                    return ((MethodReferenceType)type1).Declaration == ((MethodReferenceType)type2).Declaration;
                case AnonymousMethodType _:
                    var method1 = (AnonymousMethodType)type1;
                    var method2 = (AnonymousMethodType)type2;
                    throw new NotImplementedException();
                case ReferenceType _:
                    return ((ReferenceType)type1).Declaration == ((ReferenceType)type2).Declaration;
                case StaticReference _:
                    return ((StaticReference)type1).Declaration == ((StaticReference)type2).Declaration;
                case TypeList _:
                    var list1 = ((TypeList)type1).SubTypes.ToList();
                    var list2 = ((TypeList)type2).SubTypes.ToList();
                    if (list1.Count != list2.Count)
                        return false;
                    foreach (var permutation in list1.GetAllPermutations())
                    {
                        if (permutation.Zip(list2, (t1, t2) => t1.IsEquivalentTo(t2)).All(x => x))
                            return true;
                    }

                    return false;
                case BoolType _:
                case NumberType _:
                case StringType _:
                    return true;
                case GenericType _:
                    var genericType1 = (GenericType)type1;
                    var genericType2 = (GenericType)type2;

                    return genericType1.Base.IsEquivalentTo(genericType2.Base)
                           && genericType1.GenericTypes.Count() == genericType2.GenericTypes.Count()
                           && genericType1.GenericTypes.Zip(genericType2.GenericTypes, (subType1, subType2) => subType1.IsEquivalentTo(subType2)).All(x => x);
                default:
                    throw new Exception("Internal error, unexpected type: " + type1.GetType().FullName);
            }
        }

        public static bool IsAssignableTo(this IType fromType, IType toType)
        {
            if (fromType is TypeNodeWrapper fromWrapper)
                return fromWrapper.Type.IsEquivalentTo(toType);
            if (toType is TypeNodeWrapper toWrapper)
                return fromType.IsEquivalentTo(toWrapper.Type);
            if (fromType is TypeList fromTypeList)
                return fromTypeList.SubTypes.All(x => x.IsAssignableTo(toType));
            if (toType is TypeList toTypeList)
                return toTypeList.SubTypes.Any(fromType.IsAssignableTo);
            if (fromType is VoidType || toType is VoidType || fromType is StaticReference || toType is StaticReference)
                return false;
            if (fromType is NullType)
                return true;
            if (toType is NullType)
                return false;
            if (fromType.IsEquivalentTo(toType))
                return true;
            if (fromType is AnonymousMethodType anonymousMethodFromType && toType is FunctionType functionToType)
                return anonymousMethodFromType.ReturnType.IsEquivalentTo(functionToType.ReturnType)
                       && anonymousMethodFromType.Expression.Variables.Select(x => x.Type).Zip(functionToType.Parameters.Select(x => x.Type), (x, y) => x.IsEquivalentTo(y)).All(x => x);
            return false;
        }


    }
}