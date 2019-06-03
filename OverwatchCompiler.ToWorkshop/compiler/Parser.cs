using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using Antlr4.Runtime;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public interface IParser
    {
        TypescriptParser.SourceFilesContext LoadFileAndImports(string originalFilename);
    }

    public class Parser : IParser
    {
        public TypescriptParser.SourceFilesContext LoadFileAndImports(string originalFilename)
        {
            var queue = new Queue<string>();
            queue.Enqueue(Path.GetFullPath(originalFilename));
            var errors = new List<string>();
            var loadedFiles = new Dictionary<string, TypescriptParser.SourceFileContext>();

            while (queue.Count > 0)
            {
                var filename = queue.Dequeue();
                if (loadedFiles.ContainsKey(filename))
                    continue;

                var sourceFile = LoadFile(filename, ref errors);
                loadedFiles.Add(filename, sourceFile);

                foreach (var importDeclaration in sourceFile.importDeclaration())
                {
                    queue.Enqueue(importDeclaration.TargetPath);
                }
            }

            foreach (var error in errors)
            {
                Console.WriteLine(error);
            }
            if (errors.Any())
            {
                throw new Exception("Compilation failed.");
            }

            var sourceFiles = new TypescriptParser.SourceFilesContext(null, 0);
            foreach (var sourceFile in loadedFiles.Values)
            {
                foreach (var importDeclaration in sourceFile.importDeclaration())
                {
                    importDeclaration.TargetFile = loadedFiles[importDeclaration.TargetPath];
                }

                sourceFile.Parent = sourceFiles;
                sourceFiles.AddChild(sourceFile);
            }

            return sourceFiles;
        }

        private TypescriptParser.SourceFileContext LoadFile(string filename, ref List<string> errors)
        {
            var antlrStream = new AntlrFileStream(filename);
            var lexer = new TypescriptLexer(antlrStream);
            var tokens = new CommonTokenStream(lexer);

            var parser = new TypescriptParser(tokens);
            var errorListener = new ErrorListener(filename);
            parser.RemoveErrorListeners();
            parser.RemoveParseListeners();
            parser.AddErrorListener(errorListener);
            var sourceFile = parser.sourceFile();
            errors.AddRange(errorListener.Errors);

            if (sourceFile == null)
                return null;

            sourceFile.FilePath = filename;
            return sourceFile;
        }
    }

}