package com.github.konbluesky.jdph.jdpm;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;

/**
 * <p> @Date : 2021/8/11 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
@ToString
@Getter
@Slf4j
public class ProjectEtc {

    private static final Set<String> IMAGE_FILE_SUFFIX = Sets.newHashSet("jpg", "jpeg", "gif", "png", "svg");

    private String[] files = new String[0];

    private String imagePath;

    private File imageFile;

    public ProjectEtc(String etcFullPath) {
        try {
            this.files = Files.list(Paths.get(etcFullPath))
                              .sorted()
                              .map(path -> path.toFile()
                                               .getName())
                              .toArray(String[]::new);

            for (String filename : files) {
                if (IMAGE_FILE_SUFFIX.contains(com.google.common.io.Files.getFileExtension(filename)
                                                                         .toLowerCase())) {
                    this.imagePath = filename;
                }
            }
        } catch (IOException e) {
            log.error("Failed to parse etc directory [{}]", etcFullPath);
        }
    }

    public boolean hasUMLImage() {
        return !Strings.isNullOrEmpty(imagePath);
    }

    public File getImageFile() {
        Preconditions.checkNotNull(imagePath, "UML image not found");
        if (imageFile == null) {
            this.imageFile = getFile(imagePath);
        }
        return this.imageFile;
    }

    private File getFile(String filePath) {
        return new File(filePath);
    }
}
