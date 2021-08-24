package com.github.konbluesky.jdph.listeners;

import com.github.konbluesky.jdph.setting.AppSettingsState;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import org.jetbrains.annotations.NotNull;

public class MyProjectManagerListener implements ProjectManagerListener {

    @Override
    public void projectOpened(@NotNull Project project) {
    }
}
