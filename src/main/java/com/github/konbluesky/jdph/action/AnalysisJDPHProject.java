package com.github.konbluesky.jdph.action;

import com.github.konbluesky.jdph.jdpm.ProjectScanner;
import com.github.konbluesky.jdph.setting.AppSettingsState;
import com.github.konbluesky.jdph.utils.NotifyUtils;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.util.text.Strings;

/**
 * <p> @Date : 2021/8/11 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
public class AnalysisJDPHProject extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        AppSettingsState settings = ServiceManager.getService(e.getProject(), AppSettingsState.class);
        if (Strings.isEmpty(settings.javaDesignPatternProjectLocalPath)) {
            NotifyUtils.notifyMessage(e.getProject(), "请配置javaDesignPatternProjectLocalPath");
        } else {
            ProjectScanner projectScanner = new ProjectScanner(settings.javaDesignPatternProjectLocalPath);
            projectScanner.scan().forEach(p->{
                System.out.println(p.getReadme());
            });
        }
    }
}
