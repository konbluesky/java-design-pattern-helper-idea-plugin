package com.github.konbluesky.jdph.services;

import com.github.konbluesky.javadesignpatternhelperideaplugin.MyBundle;
import com.intellij.openapi.project.Project;

public class MyProjectService {

    private Project project;

    public MyProjectService(Project project) {
        this.project = project;
        System.out.println(MyBundle.message("projectService", project.getName()));
    }
}
