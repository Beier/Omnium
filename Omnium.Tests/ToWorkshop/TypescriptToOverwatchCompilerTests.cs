﻿using System;
using System.IO;
using NUnit.Framework;
using Omnium.Core.compiler;
using Omnium.Core.compiler.step1Parsing;
using Omnium.Core.compiler.step1Parsing.antlr;

namespace Omnium.Tests.ToWorkshop
{
    [TestFixture]
    public class TypescriptToOverwatchCompilerTests
    {
        [TestCase("HelloWorld")]
        [TestCase("CountShots")]
        [TestCase("ConstantLoopUnrolling")]
        [TestCase("NonConstantLoopUnrolling")]
        [TestCase("TestArraySize")]
        [TestCase("ModuleAndClassOfSameName")]
        [TestCase("LambdaMethods")]
        [TestCase("LowercaseStrings")]
        [TestCase("Chase")]
        [TestCase("CustomPlayerVariables")]
        [TestCase("Reevaluation")]
        public void RunTest(string testName)
        {
            var compiler = new TypescriptToOverwatchCompiler();

            var exeLocation = AppDomain.CurrentDomain.BaseDirectory;
            var code = compiler.Compile($"{exeLocation}/ToWorkshop/Data/{testName}/Input.ts");
            var expectedOutput = File.ReadAllText($"{exeLocation}/ToWorkshop/Data/{testName}/ExpectedOutput.txt");

            code = code.Replace("\r", "");
            expectedOutput = expectedOutput.Replace("\r", "");

            Assert.AreEqual(expectedOutput, code);
        }
    }
}