using System;
using System.Linq;
using OverwatchCompiler.ToWorkshop.compiler;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public static class TypeExtensions
    {
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
                case ArrayType _:
                    return ((ArrayType)type1).Base.Value.IsEquivalentTo(((ArrayType)type2).Base.Value);
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
                return anonymousMethodFromType.ReturnType.IsEquivalentTo(functionToType.ReturnType.Value)
                       && anonymousMethodFromType.Expression.Parameters.Select(x => x.Type.Value).Zip(functionToType.Parameters.Select(x => x.Type.Value), (x, y) => x.IsEquivalentTo(y)).All(x => x);
            return false;
        }


    }
}