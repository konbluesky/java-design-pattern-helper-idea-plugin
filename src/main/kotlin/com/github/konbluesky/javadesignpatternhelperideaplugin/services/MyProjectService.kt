package com.github.konbluesky.javadesignpatternhelperideaplugin.services

import com.github.konbluesky.javadesignpatternhelperideaplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
