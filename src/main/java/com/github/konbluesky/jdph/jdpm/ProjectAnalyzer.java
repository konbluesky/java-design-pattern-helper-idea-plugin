package com.github.konbluesky.jdph.jdpm;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import lombok.Setter;

/**
 * Mainly used to deconstruct a certain design pattern folder
 * <p> @Date : 2021/8/11 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
public class ProjectAnalyzer {

    @Setter
    private String projectPath;

    private JDPHProject jdphProject;

    public ProjectAnalyzer() {

    }

    public ProjectAnalyzer(String projectPath) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(projectPath), "Project path can't be blank");
        this.projectPath = projectPath;
    }

    public JDPHProject analysis() {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(projectPath), "Project path can't be blank");
        if (jdphProject == null) {
            this.jdphProject = new JDPHProject(projectPath);
            ProjectScanner projectScanner = new ProjectScanner(projectPath);
            this.jdphProject.setProjects(projectScanner.scan());
        }
        return jdphProject;
    }
}
