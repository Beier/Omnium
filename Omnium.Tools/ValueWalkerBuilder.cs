using System;
using System.Linq;
using System.Reflection;
using System.Text;
using Omnium.Core.ast;

namespace Omnium.Tools
{
    public class ValueWalkerBuilder
    {
        public static void BuildValueWalker()
        {
            var nodeTypes =
                Assembly
                    .GetAssembly(typeof(INode))
                    .GetTypes()
                    .Where(x => typeof(INode).IsAssignableFrom(x))
                    .Where(x => x.IsAbstract == false && x.IsInterface == false)
                    .OrderBy(Util.DistanceToINode)
                    .Reverse()
                    .ToList();


            var builder = new StringBuilder();
            builder.AppendLine("using System;");
            builder.AppendLine("using System.Collections.Generic;");
            builder.AppendLine("using System.Linq;");
            builder.AppendLine("using Omnium.Core.ast;");
            builder.AppendLine("using Omnium.Core.ast.declarations;");
            builder.AppendLine("using Omnium.Core.ast.expressions;");
            builder.AppendLine("using Omnium.Core.ast.expressions.literals;");
            builder.AppendLine("using Omnium.Core.ast.statements;");
            builder.AppendLine("using Omnium.Core.ast.types;");
            builder.AppendLine();
            builder.AppendLine("namespace Omnium.Core.compiler");
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
    }
}