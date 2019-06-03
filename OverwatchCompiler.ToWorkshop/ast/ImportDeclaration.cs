using System.IO;

public partial class TypescriptParser
{
    public partial class ImportDeclarationContext
    {

        public SourceFileContext TargetFile { get; set; }

        public string TargetPath
        {
            get
            {
                var parent = (SourceFileContext) Parent;
                var currentFolder = new FileInfo(parent.FilePath).Directory.FullName;
                var importPath = Path.Combine(currentFolder, stringLiteral().Value);
                return Path.GetFullPath(importPath);
            }

        }

    }
}