# java-design-pattern-helper-idea-plugin(JDPH)

<!-- Plugin description -->

A plug-in related to design patterns, intended to help engineers use common design patterns quickly. 

The design pattern quoted from [https://github.com/iluwatar/java-design-patterns](https://github.com/iluwatar/java-design-patterns)

<!-- Plugin description end -->

## Screenshot

![Build](https://github.com/konbluesky/java-design-pattern-helper-idea-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

## Planning

- Super friendly GUI
- Support preview of common design patterns: UML diagrams, project files
- Automatically register the design pattern to the `Live Template` in IDEA
- According to a pattern, intelligently match the similar code of the current project

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "
  java-design-pattern-helper-idea-plugin"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/konbluesky/java-design-pattern-helper-idea-plugin/releases/latest)
  and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template

##### reference

- https://plugins.jetbrains.com/docs/intellij/welcome.html
- https://intellij-support.jetbrains.com/hc/en-us/community/posts/360001508700-Use-action-of-another-plugin-inside-my-plugin
- https://intellij-support.jetbrains.com/hc/en-us/community/posts/206780745-Is-it-possible-to-trigger-function-action-of-another-plugin-from-a-plugin-
- https://stackoverflow.com/questions/9639017/intellij-gui-creator-jpanel-gives-runtime-null-pointer-exception-upon-adding-an/35431318
- https://www.tabnine.com/code/java/classes/com.intellij.uiDesigner.core.GridConstraints
- https://www.jetbrains.com/help/idea/designing-gui-major-steps.html
- https://github.com/pRivAte12/android-component-explorer
- https://github.com/Link-Kou/intellij-treeInfotip
- https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000316704-Create-custom-Tree-View-in-a-Tool-Window
- https://www.plugin-dev.com/intellij/editor/editor-open-close/
- https://docs.oracle.com/javase/tutorial/uiswing/index.html
