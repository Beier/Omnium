using System;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using Omnium.Core.ast;

namespace Omnium.Tools
{
    public class VoidWalkerBuilder
    {
        public static void BuildVoidWalker()
        {
            var nodeTypes =
                Assembly
                    .GetAssembly(typeof(INode))
                    .GetTypes()
                    .Where(x => typeof(INode).IsAssignableFrom(x))
                    .OrderBy(Util.DistanceToINode)
                    .ToList();


            var builder = new StringBuilder();
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
            builder.AppendLine("    public abstract class TreeVoidWalker");
            builder.AppendLine("    {");
            builder.AppendLine("        protected bool skipChildren = false;");
            builder.AppendLine("        public readonly List<CompilationError> Errors = new List<CompilationError>();");
            builder.AppendLine("        public readonly List<CompilationError> Warnings = new List<CompilationError>();");
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


            var filePath = Path.Combine(Directory.GetCurrentDirectory(), "..\\..\\..\\Omnium.Core\\Compiler\\TreeVoidWalker.cs");
            using (var fileStream = new StreamWriter(File.Create(filePath)))
            {
                fileStream.Write(result);
            }
        }
    }
}