package com.github.konbluesky.jdph.setting;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.github.konbluesky.jdph.setting.JDPConstants.JAVA_DESIGN_PATTERN_PROJECT_PATH;
import static com.github.konbluesky.jdph.setting.JDPConstants.JAVA_DESIGN_PATTERN_PROJECT_URL;

/**
 * Persistent configuration of the plugin
 * <p> @Date : 2021/8/11 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
@State(name = "JavaDesignPatternHelper", storages = { @Storage("java-design-pattern-idea-setting.xml") })
public class AppSettingsState implements PersistentStateComponent<AppSettingsState> {

    public String javaDesignPatternProjectUrl = JAVA_DESIGN_PATTERN_PROJECT_URL;

    public String javaDesignPatternProjectLocalPath = JAVA_DESIGN_PATTERN_PROJECT_PATH;

    public static AppSettingsState getInstance(Project project) {
        return ServiceManager.getService(project, AppSettingsState.class);
    }

    @Override
    public @Nullable AppSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull AppSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
