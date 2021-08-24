package com.github.konbluesky.jdph.jdpm;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p> @Date : 2021/8/11 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
public class JDPHProject {

    private String fullPath;

    @Getter
    @Setter
    private List<ProjectItem> projects;

    public JDPHProject(String fullPath) {
        this.fullPath = fullPath;
    }

    public ProjectItem getProject(String projectName) {
        return projects.stream()
                       .filter(projectItem -> projectItem.getProjectName()
                                                         .equalsIgnoreCase(projectName))
                       .findAny()
                       .get();
    }
}
