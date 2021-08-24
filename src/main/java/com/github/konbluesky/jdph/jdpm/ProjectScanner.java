package com.github.konbluesky.jdph.jdpm;

import com.google.common.collect.Sets;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p> @Date : 2021/8/11 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
@ToString
@Slf4j
public class ProjectScanner {

    private static Set<String> excludeDirectory = Sets.newHashSet("localization", ".mvn", ".git", ".idea", ".github", ".circleci");

    private String jdphFullPath;

    public ProjectScanner(String jdphFullPath) {
        this.jdphFullPath = jdphFullPath;
    }

    public ProjectScanner(String jdphFullPath, String... excludesDir) {
        this.jdphFullPath = jdphFullPath;
        excludeDirectory = Sets.newHashSet(excludesDir);
    }

    public List<ProjectItem> scan() {
        List<ProjectItem> projects = new ArrayList<>();
        try {
            Files.list(Paths.get(jdphFullPath))
                 .sorted()
                 //过滤目录
                 .filter(path -> path.toFile()
                                     .isDirectory())
                 //排除无效文件夹
                 .filter(path -> !excludeDirectory.contains(path.getName(path.getNameCount() - 1)
                                                                .toFile()
                                                                .getName()))
                 .forEach(p -> {
                     projects.add(new ProjectItem(p.toAbsolutePath()
                                                   .toString()));
                 });
        } catch (IOException e) {
            log.error(e.toString());
        }
        return projects;
    }
}
