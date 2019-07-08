using System;
using System.Collections.Generic;
using System.Linq;
using Omnium.Core.ast;

namespace Omnium.Tools
{
    public class Util
    {
        public static int DistanceToINode(Type type)
        {
            if (type == typeof(INode))
                return 0;
            if (!typeof(INode).IsAssignableFrom(type))
                return -1;

            return GetUniqueSuperTypes(type)
                       .Select(DistanceToINode)
                       .Max() + 1;
        }

        private static IEnumerable<Type> GetUniqueSuperTypes(Type type)
        {
            var superTypes = GetSuperTypes(type).ToList();

            foreach (var superDuberType in superTypes.SelectMany(GetSuperTypes).ToList())
            {
                superTypes.Remove(superDuberType);
            }

            return superTypes;
        }

        private static IEnumerable<Type> GetSuperTypes(Type type)
        {
            if (type.BaseType != null && type.BaseType != typeof(object))
                yield return type.BaseType;
            foreach (var @interface in type.GetInterfaces())
            {
                yield return @interface;
            }

        }
    }
}