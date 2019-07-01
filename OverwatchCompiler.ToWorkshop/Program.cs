using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;

namespace OverwatchCompiler.ToWorkshop
{
    class Program
    {
        static void Main(string[] args)
        {
            BuildValueWalker();
            BuildVoidWalker();
        }

        private static void BuildVoidWalker()
        {
            var nodeTypes =
                Assembly
                    .GetAssembly(typeof(INode))
                    .GetTypes()
                    .Where(x => typeof(INode).IsAssignableFrom(x))
                    .OrderBy(DistanceToINode)
                    .ToList();


            var builder = new StringBuilder();
            builder.AppendLine("using System.Collections.Generic;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast.declarations;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast.expressions;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast.expressions.literals;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast.statements;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast.types;");
            builder.AppendLine();
            builder.AppendLine("namespace OverwatchCompiler.ToWorkshop.compiler");
            builder.AppendLine("{");
            builder.AppendLine("    public abstract class TreeVoidWalker");
            builder.AppendLine("    {");
            builder.AppendLine("        protected bool skipChildren = false;");
            builder.AppendLine("        public readonly List<CompilationError> Errors = new List<CompilationError>();");
            builder.AppendLine();
            builder.AppendLine("        public virtual void Visit(INode node)");
            builder.AppendLine("        {");
            builder.AppendLine("            if (node == null)");
            builder.AppendLine("                return;");

            foreach (var nodeType in nodeTypes)
            {
                var typeName = nodeType.Name;
                builder.AppendLine($"            if (node is {typeName})");
                builder.AppendLine($"                Enter{typeName}(({typeName}) node);");
            }

            builder.AppendLine("            if (skipChildren)");
            builder.AppendLine("                skipChildren = false;");
            builder.AppendLine("            else");
            builder.AppendLine("                foreach (var child in node.Children.ToList())");
            builder.AppendLine("                    Visit(child);");

            foreach (var nodeType in nodeTypes)
            {
                var typeName = nodeType.Name;
                builder.AppendLine($"            if (node is {typeName})");
                builder.AppendLine($"                Exit{typeName}(({typeName}) node);");
            }

            builder.AppendLine("        }");
            builder.AppendLine();

            foreach (var nodeType in nodeTypes)
            {
                var typeName = nodeType.Name;
                var variableName = typeName[0].ToString().ToLower() + typeName.Substring(1);
                builder.AppendLine($"        public virtual void Enter{typeName}({typeName} {variableName}) {{ }}");
                builder.AppendLine($"        public virtual void Exit{typeName}({typeName} {variableName}) {{ }}");
            }


            builder.AppendLine("    }");
            builder.AppendLine("}");

            var result = builder.ToString();
            Console.WriteLine(result);
        }

        private static void BuildValueWalker()
        {
            var nodeTypes =
                Assembly
                    .GetAssembly(typeof(INode))
                    .GetTypes()
                    .Where(x => typeof(INode).IsAssignableFrom(x))
                    .Where(x => x.IsAbstract == false && x.IsInterface == false)
                    .OrderBy(DistanceToINode)
                    .Reverse()
                    .ToList();


            var builder = new StringBuilder();
            builder.AppendLine("using System;");
            builder.AppendLine("using System.Collections.Generic;");
            builder.AppendLine("using System.Linq;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast.declarations;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast.expressions;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast.expressions.literals;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast.statements;");
            builder.AppendLine("using OverwatchCompiler.ToWorkshop.ast.types;");
            builder.AppendLine();
            builder.AppendLine("namespace OverwatchCompiler.ToWorkshop.compiler");
            builder.AppendLine("{");
            builder.AppendLine("    public abstract class TreeValueWalker<T>");
            builder.AppendLine("    {");
            builder.AppendLine("        public readonly List<CompilationError> Errors = new List<CompilationError>();");
            builder.AppendLine();
            builder.AppendLine("        public abstract T GetDefault(INode node);");
            builder.AppendLine("        public abstract T Combine(T v1, T v2);");
            builder.AppendLine();
            builder.AppendLine("        public virtual T VisitChildren(INode node)");
            builder.AppendLine("        {");
            builder.AppendLine("            var children = node.Children.ToList();");
            builder.AppendLine("            if (children.Count == 0)");
            builder.AppendLine("                return GetDefault(node);");
            builder.AppendLine("            return children.Select(Visit).Aggregate(Combine);");
            builder.AppendLine("        }");
            builder.AppendLine();
            builder.AppendLine("        public virtual T Visit(INode node)");
            builder.AppendLine("        {");

            foreach (var nodeType in nodeTypes)
            {
                var typeName = nodeType.Name;
                builder.AppendLine($"            if (node is {typeName})");
                builder.AppendLine($"                return Visit{typeName}(({typeName}) node);");
            }

            builder.AppendLine("            throw new Exception(\"Unexpected node type: \" + node?.GetType().FullName);");
            builder.AppendLine("        }");

            foreach (var nodeType in nodeTypes)
            {
                var typeName = nodeType.Name;
                var variableName = typeName[0].ToString().ToLower() + typeName.Substring(1);
                builder.AppendLine();
                builder.AppendLine($"        public virtual T Visit{typeName}({typeName} {variableName})");
                builder.AppendLine("        {");
                builder.AppendLine($"            return VisitChildren({variableName});");
                builder.AppendLine("        }");
            }


            builder.AppendLine("    }");
            builder.AppendLine("}");

            var result = builder.ToString();
            Console.WriteLine(result);
        }

        private static int DistanceToINode(Type type)
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
