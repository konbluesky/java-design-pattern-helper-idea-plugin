package com.github.konbluesky.jdph.setting;

import com.intellij.openapi.diagnostic.ErrorReportSubmitter;
import org.jetbrains.annotations.NotNull;

/**
 * <p> @Date : 2021/8/24 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
public class JDPHErrorReportSubmitter extends ErrorReportSubmitter {

    @Override
    public @NotNull String getReportActionText() {
        return null;
    }
}
