package com.thedroidboy.customlint;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.ApiKt;
import com.android.tools.lint.detector.api.Issue;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class SmartLoggerIssueRegistry extends IssueRegistry {

    @NotNull
    @Override public List<Issue> getIssues() {
        return Arrays.asList(SmartLoggerDetector.getIssues());
    }

    @Override public int getApi() {
        return ApiKt.CURRENT_API;
    }
}