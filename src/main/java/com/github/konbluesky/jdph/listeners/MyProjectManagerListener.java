package com.github.konbluesky.jdph.listeners;

import com.github.konbluesky.jdph.services.MyProjectService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import org.jetbrains.annotations.NotNull;

public class MyProjectManagerListener implements ProjectManagerListener {

    @Override
    public void projectOpened(@NotNull Project project) {
        System.out.println("Project is opened");
        project.getService(MyProjectService.class);
    }
}
