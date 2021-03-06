﻿using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using Antlr4.Runtime;

namespace Omnium.Core.compiler.step1Parsing.antlr
{
    public class AntlrParser
    {
        public static TypescriptParser.SourceFilesContext ParseAntlrAst(string[] originalFilenames)
        {
            var queue = new Queue<string>();
            foreach (var originalFilename in originalFilenames)
            {
                queue.Enqueue(Path.GetFullPath(originalFilename));
            }
            var errors = new List<string>();
            var loadedFiles = new Dictionary<string, TypescriptParser.SourceFileContext>();

            while (queue.Count > 0)
            {
                var filename = queue.Dequeue().ToLower();
                if (loadedFiles.ContainsKey(filename))
                    continue;

                var sourceFile = LoadFile(filename, ref errors);
                if (sourceFile != null)
                {
                    loadedFiles.Add(filename, sourceFile);

                    foreach (var importDeclaration in sourceFile.importDeclaration())
                    {
                        var targetPath = importDeclaration.TargetPath.ToLower();
                        if (!targetPath.EndsWith(".ts"))
                            targetPath += ".ts";
                        queue.Enqueue(targetPath);
                    }
                }
            }

            foreach (var error in errors)
            {
                Console.WriteLine(error);
            }
            if (errors.Any())
            {
                return null;
            }

            var sourceFiles = new TypescriptParser.SourceFilesContext(null, 0);
            foreach (var sourceFile in loadedFiles.Values)
            {
                foreach (var importDeclaration in sourceFile.importDeclaration())
                {
                    var targetPath = importDeclaration.TargetPath.ToLower();
                    if (!targetPath.EndsWith(".ts"))
                        targetPath += ".ts";
                    importDeclaration.TargetFile = loadedFiles[targetPath];
                }

                sourceFile.Parent = sourceFiles;
                sourceFiles.AddChild(sourceFile);
            }

            return sourceFiles;
        }

        private static TypescriptParser.SourceFileContext LoadFile(string filename, ref List<string> errors)
        {
            if (!File.Exists(filename))
            {
                errors.Add($"File '{filename}' was not found");
                return null;
            }

            var antlrStream = new AntlrFileStream(filename);
            var lexer = new TypescriptLexer(antlrStream);
            var tokens = new CommonTokenStream(lexer);

            var parser = new TypescriptParser(tokens);
            var errorListener = new ErrorListener(filename);
            parser.RemoveErrorListeners();
            parser.RemoveParseListeners();
            parser.AddErrorListener(errorListener);
            parser.AddParseListener(new ParserValidation(errorListener));
            var sourceFile = parser.sourceFile();
            errors.AddRange(errorListener.Errors);

            if (sourceFile == null)
                return null;

            sourceFile.FilePath = filename;
            return sourceFile;
        }
    }

}