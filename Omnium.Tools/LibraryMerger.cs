//using System.IO;
//using System.Linq;

//namespace Omnium.Tools
//{
//    public class LibraryMerger
//    {
//        public static void MergeLibrary()
//        {
//            var inputFolder = "C:\\git\\overwatch-typescript-compiler\\Omnium.Core\\library";
//            var outputFolder = "C:\\git\\overwatch-typescript-compiler\\Omnium.Compiler\\library";

//            var order = new[]
//            {
//                "native.ts",
//                "list.ts",
//                "vector.ts",
//                "events.ts",
//                "game.ts",
//                "hero.ts",
//                "player.ts",
//                "team.ts",
//                "strings.ts"
//            };


//            using (var outputStream = new StreamWriter(File.Create(outputFolder + "/core.ts")))
//            {
//                foreach (var inputFile in Directory.GetFiles(inputFolder).Where(x => order.Contains(Path.GetFileName(x))).OrderBy(x => order.IndexOf(Path.GetFileName(x))))
//                {
//                    using (var inputStream = new StreamReader(File.OpenRead(inputFile)))
//                    {
//                        while (true)
//                        {
//                            var line = inputStream.ReadLine();
//                            if (line == null)
//                                break;
//                            outputStream.WriteLine(line);
//                        }
//                    }
//                }
//            }
//        }
//    }
//}