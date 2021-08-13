package com.github.konbluesky.jdph.jdpm;

import lombok.Getter;
import lombok.ToString;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p> @Date : 2021/8/11 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
@ToString
@Getter
public class ProjectItem {

    private String fullPath;

    private String projectName;

    private ProjectEtc etc;

    private String readme;

    public ProjectItem(String fullPath) {
        this.fullPath = fullPath;
        resolve();
    }

    private void resolve() {
        /* 1.工程name */
        Path projectPath = Paths.get(fullPath);
        this.projectName = projectPath.getName(projectPath.getNameCount() - 1)
                                      .getFileName()
                                      .toString();

        /* 2.解析etc目录 */
        Path etcPath = Paths.get(fullPath, "etc");
        this.etc = new ProjectEtc(etcPath.toString());

        /* 3.readme */
        Path readmePath = Paths.get(fullPath, "README.md");
        File readmeFile = readmePath.toFile();

        if (readmeFile.exists()) {
            readme = readmePath.toString();
        }
    }
}
