java -jar "..\..\libraries\antlr\antlr-4.7.2-complete.jar" -Dlanguage=CSharp -o "generated" "TypescriptLexer.g4"
java -jar "..\..\libraries\antlr\antlr-4.7.2-complete.jar" -Dlanguage=CSharp "TypescriptLexer.g4"
java -jar "..\..\libraries\antlr\antlr-4.7.2-complete.jar" -visitor -Dlanguage=CSharp -o "generated" "TypescriptParser.g4"