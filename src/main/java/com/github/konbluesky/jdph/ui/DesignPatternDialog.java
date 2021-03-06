package com.github.konbluesky.jdph.ui;

import com.github.konbluesky.jdph.JDPHBundle;
import com.github.konbluesky.jdph.jdpm.JDPHProject;
import com.github.konbluesky.jdph.jdpm.ProjectAnalyzer;
import com.github.konbluesky.jdph.setting.AppSettingsState;
import com.github.konbluesky.jdph.utils.NotifyUtils;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.fileChooser.ex.FileSystemTreeImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.EditorTextField;
import com.intellij.ui.ListSpeedSearch;
import com.intellij.ui.components.JBList;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.io.File;
import java.io.IOException;

/**
 * examples:
 * https://vimsky.com/examples/detail/java-class-com.intellij.uiDesigner.core.GridLayoutManager.html
 *
 * <p> @Date : 2021/8/13 </p>
 * <p> @Project : java-design-pattern-helper-idea-plugin</p>
 *
 * <p> @author konbluesky </p>
 */
public class DesignPatternDialog extends DialogWrapper {

    private JPanel contentPanel;

    private JBList projectList;

    private JPanel leftPanel;

    private JPanel middlePanel;

    private JPanel rightPanel;

    private JScrollPane projectListScrollPanel;

    private Tree fileTree;

    private JScrollPane fileTreeScrollPanel;

    private EditorTextField editorTextField;

    private Project project;

    private JDPHProject jdphProject;

    private AppSettingsState appSettingsState;

    private FileSystemTreeImpl fileSystemTree;

    public DesignPatternDialog(@Nullable Project project) {
        super(project, true, DialogWrapper.IdeModalityType.PROJECT);
        this.project = project;
        appSettingsState = AppSettingsState.getInstance(project);
        setModal(false);
        setTitle(JDPHBundle.message("plugin.name"));
        init();
    }

    private void onCancel() {
        this.dispose();
    }

    private void initLeftPanelUI() {
        ProjectAnalyzer projectAnalyzer = new ProjectAnalyzer(appSettingsState.javaDesignPatternProjectLocalPath);
        jdphProject = projectAnalyzer.analysis();

        DefaultListModel<String> lists = new DefaultListModel<>();
        jdphProject.getProjects().forEach(p -> {
            lists.addElement(p.getProjectName());
        });
        projectList.setModel(lists);

        projectList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                VirtualFile selectProject = LocalFileSystem.getInstance().findFileByIoFile(new File(jdphProject.getProject((String) projectList.getSelectedValue())
                                                                                                               .getFullPath()));
                FileChooserDescriptor fileChooserDescriptor = FileChooserDescriptorFactory.createSingleFileOrFolderDescriptor().withRoots(selectProject);
                fileSystemTree = new FileSystemTreeImpl(project, fileChooserDescriptor, fileTree, null, null, null);

                fileSystemTree.updateTree();

                NotifyUtils.notifyMessage(project, (String) projectList.getSelectedValue());
            }
        });
    }

    private void initMiddlePanelUI() {
        fileTree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if (fileSystemTree != null && fileSystemTree.getSelectedFile() != null && !fileSystemTree.getSelectedFile().isDirectory()) {
                    //                    PsiFile psiFile = PsiManager.getInstance(project)
                    //                                                .findFile(fileSystemTree.getSelectedFile());
                    editorTextField.setFileType(JavaFileType.INSTANCE);
                    try {
                        editorTextField.setText(new String(fileSystemTree.getSelectedFile().contentsToByteArray()));
                        editorTextField.setAutoscrolls(true);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * createCenterPanel
     * ??????????????????????????????,???????????????????????????,?????????new????????????????????????set?????????????
     *
     * @return
     */
    @Override
    protected @Nullable JComponent createCenterPanel() {
        initLeftPanelUI();
        initMiddlePanelUI();
        editorTextField.setText("Init TextField");
        new ListSpeedSearch(projectList);
        return contentPanel;
    }

    private void createUIComponents() {
        Tree defaultTree = new Tree();

        FileChooserDescriptor fileChooserDescriptor = FileChooserDescriptorFactory.createSingleLocalFileDescriptor().withRoots(LocalFileSystem.getInstance()
                                                                                                                                              .findFileByIoFile(new File(
                                                                                                                                                      "/Users/konbluesky/work/java-design-patterns/abstract-document")));
        FileSystemTreeImpl FileSystemTreeImpl = new FileSystemTreeImpl(this.project, fileChooserDescriptor, defaultTree, null, null, null);
        this.fileTree = (Tree) FileSystemTreeImpl.getTree();
    }
}
