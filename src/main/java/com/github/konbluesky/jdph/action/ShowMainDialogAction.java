package com.github.konbluesky.jdph.action;

import com.github.konbluesky.jdph.ui.DesignPatternDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.fileEditor.TextEditorWithPreview;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;

import java.nio.file.Paths;

/**
 * <p> @Date : 2021/8/13 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
public class ShowMainDialogAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
//        Editor editor = e.getData(PlatformDataKeys.EDITOR);
//        VirtualFile fixedReadmeFile = VirtualFileManager.getInstance()
//                                                        .findFileByNioPath(Paths.get("/Users/konbluesky/work/java-design-patterns/callback/README.md"));
//        ;
//        FileEditor[] fileEditor = FileEditorManager.getInstance(e.getProject())
//                                                    .openFile(fixedReadmeFile, true);

        new DesignPatternDialog(e.getProject()).show();
    }
}
