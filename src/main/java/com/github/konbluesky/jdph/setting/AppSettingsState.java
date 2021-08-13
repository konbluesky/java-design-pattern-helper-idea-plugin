package com.github.konbluesky.jdph.setting;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.github.konbluesky.jdph.setting.JDPConstants.JAVA_DESIGN_PATTERN_PROJECT_URL;

/**
 * Persistent configuration of the plugin
 * <p> @Date : 2021/8/11 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
@State(name = "java-design-pattern.idea.plugin", storages = { @Storage("setting.xml") })
public class AppSettingsState implements PersistentStateComponent<AppSettingsState> {

    public String javaDesignPatternProjectUrl = JAVA_DESIGN_PATTERN_PROJECT_URL;
    public String javaDesignPatternProjectLocalPath;

    @Override
    public @Nullable AppSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull AppSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }


}
