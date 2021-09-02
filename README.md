# 关于设计模式的IDEA插件

https://plugins.jetbrains.com/docs/intellij/welcome.html
https://intellij-support.jetbrains.com/hc/en-us/community/posts/360001508700-Use-action-of-another-plugin-inside-my-plugin
https://intellij-support.jetbrains.com/hc/en-us/community/posts/206780745-Is-it-possible-to-trigger-function-action-of-another-plugin-from-a-plugin-
https://stackoverflow.com/questions/9639017/intellij-gui-creator-jpanel-gives-runtime-null-pointer-exception-upon-adding-an/35431318
https://www.tabnine.com/code/java/classes/com.intellij.uiDesigner.core.GridConstraints
https://www.jetbrains.com/help/idea/designing-gui-major-steps.html
https://github.com/pRivAte12/android-component-explorer
https://github.com/Link-Kou/intellij-treeInfotip
https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000316704-Create-custom-Tree-View-in-a-Tool-Window
https://www.plugin-dev.com/intellij/editor/editor-open-close/
https://docs.oracle.com/javase/tutorial/uiswing/index.html


# java-design-pattern-helper-idea-plugin

![Build](https://github.com/konbluesky/java-design-pattern-helper-idea-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [ ] Verify the [pluginGroup](/gradle.properties), [plugin ID](/src/main/resources/META-INF/plugin.xml) and [sources package](/src/main/kotlin).
- [ ] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the Plugin ID in the above README badges.
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
This Fancy IntelliJ Platform Plugin is going to be your implementation of the brilliant ideas that you have.

This specific section is a source for the [plugin.xml](/src/main/resources/META-INF/plugin.xml) file which will be extracted by the [Gradle](/build.gradle.kts) during the build process.

To keep everything working, do not remove `<!-- ... -->` sections. 
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "java-design-pattern-helper-idea-plugin"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/konbluesky/java-design-pattern-helper-idea-plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
