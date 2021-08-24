package com.github.konbluesky.jdph.utils;

import com.intellij.notification.*;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * 通知消息
 * copy from [arthas-idea-plugin]
 * @author 汪小哥
 * @date 21-12-2019
 */
public class NotifyUtils {

    private static final NotificationGroup NOTIFICATION = new NotificationGroup("JDPH", NotificationDisplayType.BALLOON, false);


    /**
     * notify message
     *
     * @param project
     * @param message
     */
    public static void notifyMessage(Project project, String message) {
        try {
            Notification currentNotify = NOTIFICATION.createNotification(message, NotificationType.INFORMATION);
            Notifications.Bus.notify(currentNotify, project);
        } catch (Exception e) {
            //
        }
    }

    /**
     * push message
     *
     * @param project
     * @param message
     * @param type
     */
    public static void notifyMessage(Project project, String message, @NotNull NotificationType type) {
        try {
            Notification currentNotify = NOTIFICATION.createNotification("",message, type,new NotificationListener.UrlOpeningListener(true));
            Notifications.Bus.notify(currentNotify, project);

        } catch (Exception e) {
            //
        }
    }

}
