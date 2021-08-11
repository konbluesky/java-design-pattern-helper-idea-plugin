package com.github.konbluesky.jdph;

import com.intellij.AbstractBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MyBundle extends AbstractBundle {

    @NonNls
    public final static String BUNDLE = "messages.MyBundle";

    protected MyBundle(@NotNull String pathToBundle) {
        super(BUNDLE);
    }

    @Override
    public @NotNull String getMessage(@NotNull String key, Object @NotNull ... params) {
        return super.getMessage(key, params);
    }
}
