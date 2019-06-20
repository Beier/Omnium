﻿using System;
using System.Collections.Generic;
using System.Linq;

namespace OverwatchCompiler.ToWorkshop.extensions
{
    public static class EnumerableExtensions
    {
        public static IEnumerable<T> Yield<T>(this T item)
        {
            yield return item;
        }

        public static IEnumerable<IEnumerable<T>> GetAllPermutations<T>(this IEnumerable<T> enumerable)
        {
            var list = enumerable.ToList();
            for (int i = 0; i < list.Count; i++)
            {
                var remainder = list.Take(i).Concat(list.Skip(i + 1));
                foreach (var tailPermutation in remainder.GetAllPermutations())
                {
                    yield return list[i].Yield().Concat(tailPermutation);

                }
            }
        }

        public static IEnumerable<TRet> Select<TIn, TRet, T1, T2>(this IEnumerable<TIn> items, Func<T1, TRet> f1, Func<T2, TRet> f2) where T1 : TIn where T2 : TIn
        {
            return items.Select(item =>
            {
                if (item is T1 t1)
                    return f1(t1);
                if (item is T2 t2)
                    return f2(t2);
                throw new Exception("Unexpected alternative: " + item?.GetType().FullName);
            });
        }

        public static IEnumerable<TRet> Select<TIn, TRet, T1, T2, T3, T4, T5>(
            this IEnumerable<TIn> items, 
            Func<T1, TRet> f1, 
            Func<T2, TRet> f2,
            Func<T3, TRet> f3,
            Func<T4, TRet> f4,
            Func<T5, TRet> f5
            ) where T1 : TIn 
            where T2 : TIn
            where T3 : TIn
            where T4 : TIn
            where T5 : TIn
        {
            return items.Select(item =>
            {
                if (item is T1 t1)
                    return f1(t1);
                if (item is T2 t2)
                    return f2(t2);
                if (item is T3 t3)
                    return f3(t3);
                if (item is T4 t4)
                    return f4(t4);
                if (item is T5 t5)
                    return f5(t5);
                throw new Exception("Unexpected alternative: " + item?.GetType().FullName);
            });
        }

    }
}