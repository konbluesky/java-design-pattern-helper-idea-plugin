package com.github.konbluesky.jdph.jdpm;

import junit.framework.TestCase;

import java.util.List;

/**
 * <p> @Date : 2021/8/13 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
public class ProjectScannerTest extends TestCase {

    public void testScan() {
        String jdphPath = "/Users/konbluesky/work/java-design-patterns";
        List<ProjectItem> projectItems = new ProjectScanner(jdphPath).scan();
        projectItems.forEach(projectItem -> {
            System.out.println(projectItem.getProjectName());
        });
    }
}