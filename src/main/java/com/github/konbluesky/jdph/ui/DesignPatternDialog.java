package com.github.konbluesky.jdph.ui;

import com.github.konbluesky.jdph.JDPHBundle;
import com.github.konbluesky.jdph.jdpm.JDPHProject;
import com.github.konbluesky.jdph.jdpm.ProjectAnalyzer;
import com.github.konbluesky.jdph.setting.AppSettingsState;
import com.github.konbluesky.jdph.utils.NotifyUtils;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.fileChooser.ex.FileSystemTreeImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.ListSpeedSearch;
import com.intellij.ui.components.JBList;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.File;

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

    private JTextArea editorTextField;

    private Project project;

    private JDPHProject jdphProject;

    private AppSettingsState appSettingsState;

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
        jdphProject.getProjects()
                   .forEach(p -> {
                       lists.addElement(p.getProjectName());
                   });
        projectList.setModel(lists);

        projectList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                VirtualFile selectProject = LocalFileSystem.getInstance()
                                                           .findFileByIoFile(new File(jdphProject.getProject((String) projectList.getSelectedValue())
                                                                                                 .getFullPath()));
                FileChooserDescriptor fileChooserDescriptor = FileChooserDescriptorFactory.createSingleFileOrFolderDescriptor()
                                                                                          .withRoots(selectProject);
                FileSystemTreeImpl fileSystemTree = new FileSystemTreeImpl(project, fileChooserDescriptor, fileTree, null, null, null);
                fileSystemTree.updateTree();
                NotifyUtils.notifyMessage(project, (String) projectList.getSelectedValue());
            }
        });
    }

    private void initMiddlePanelUI() {
    }

    /**
     * createCenterPanel
     * 不需要单独实例化控件,所有操作假设已实例,如重新new后需要将实例重新set到容器中?
     *
     * @return
     */
    @Override
    protected @Nullable JComponent createCenterPanel() {
        initLeftPanelUI();
        initMiddlePanelUI();
        editorTextField.setText("Init TextField");

        //        FileChooserDescriptor fileChooserDescriptor = FileChooserDescriptorFactory.createMultipleFoldersDescriptor();
        //
        //        MyFileCellRenderer myFileCellRenderer = new ui.MyFileCellRenderer();
        //
        //        FileSystemTreeImpl FileSystemTreeImpl = new FileSystemTreeImpl(
        //                this.project,
        //                fileChooserDescriptor,
        //                defaultTree,
        //                myFileCellRenderer,
        //                null,
        //                null
        //        );

        new ListSpeedSearch(projectList);
        return contentPanel;
    }
}
