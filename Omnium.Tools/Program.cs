using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Omnium.Tools
{
    class Program
    {
        static void Main(string[] args)
        {
            VoidWalkerBuilder.BuildVoidWalker();
            ValueWalkerBuilder.BuildValueWalker();
            //LibraryMerger.MergeLibrary();
        }
    }
}
