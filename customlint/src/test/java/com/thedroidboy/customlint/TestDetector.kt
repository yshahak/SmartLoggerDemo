package com.thedroidboy.customlint

import org.junit.Test


import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import com.android.tools.lint.checks.infrastructure.TestFiles.java


class TestDetector {


    @Test fun usingAndroidLogWithTwoArguments() {
        lint()
                .files(
                        java("""
                |package foo;
                |import android.util.Log;
                |public class App {
                |  public void onCreate() {
                |    Log.d("TAG", "msg");
                |  }
                |}""".trimMargin())
                )
                .issues(SmartLoggerDetector.ISSUE_LOG)
                .run()
                .expect("""
            |src/foo/App.java:5: Warning: Using 'Log' instead of 'SmartLogger' [LogNotSmartLogger]
            |    Log.d("TAG", "msg");
            |    ~~~~~~~~~~~~~~~~~~~
            |0 errors, 1 warnings""".trimMargin())
                .expectFixDiffs("""
            |Fix for src/foo/App.java line 4: Replace with SmartLogger.d("TAG", "msg"):
            |@@ -5 +5
            |-     Log.d("TAG", "msg");
            |+     SmartLogger.d("TAG", "msg");
            |""".trimMargin())
    }

}