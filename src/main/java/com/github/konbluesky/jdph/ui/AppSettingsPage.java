package com.github.konbluesky.jdph.ui;

import com.github.konbluesky.jdph.setting.AppSettingsState;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * <p> @Date : 2021/8/11 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
public class AppSettingsPage implements Configurable {

    private JPanel settingPanel;

    private JLabel jdpUrlLabel;

    private JLabel jdpPathLabel;

    private JTextField jdpUrlField;

    private JTextField jdpPathField;

    private Project project;

    private AppSettingsState settings;

    public AppSettingsPage(Project project) {
        this.project = project;
        settings = ServiceManager.getService(project, AppSettingsState.class);
    }

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "JDPH Idea Plugin";
    }

    @Override
    public @Nullable JComponent createComponent() {
        return settingPanel;
    }

    @Override
    public boolean isModified() {
        boolean modify = !jdpPathField.getText()
                                      .equalsIgnoreCase(settings.javaDesignPatternProjectLocalPath);
        return modify;
    }

    @Override
    public void apply() throws ConfigurationException {
        settings.javaDesignPatternProjectUrl = jdpUrlField.getText();
        settings.javaDesignPatternProjectLocalPath = jdpPathField.getText();
    }

    @Override
    public void reset() {
        settings.javaDesignPatternProjectUrl=jdpUrlField.getText();
        settings.javaDesignPatternProjectLocalPath = jdpPathField.getText();
    }
}
