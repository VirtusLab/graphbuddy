# Say hello to Graph Buddy!

## Your new best pal to help you understand your Scala code better

With today's IDEs we are all forced to browse code by looking at flat-file structures, with almost no information about the semantic dependencies between them.
What if we could take a look at our code from above - and instead of seeing just text files - go through colorful graph nodes that instantly and clearly show you dependencies and other important bits extracted from your codebase?

## How Graph Buddy can help you?

Graph Buddy allows you to extract abstract semantic graph data from your project, giving you more context about the code.
The graph is augmented with additional useful data and features that will help you better understand the structure and connections in your codebase. Graph Buddy aims to speed up your process of reading and learning about the project.

![Graph Buddy User flow](assets/images/gifs/extension-3-extendedflow.gif)
---

# Table of Contents

- [Say hello to Graph Buddy!](#say-hello-to-graph-buddy)
  - [Your new best pal to help you understand your Scala code better](#your-new-best-pal-to-help-you-understand-your-scala-code-better)
  - [How Graph Buddy can help you?](#how-graph-buddy-can-help-you)
- [Table of Contents](#table-of-contents)
- [Supported languages](#supported-languages)
- [Installing and configuring the extension](#installing-and-configuring-the-extension)
  - [Your project configuration](#your-project-configuration)
    - [Scala configuration](#scala-configuration)
    - [TypeScript configuration (experimental support)](#typescript-configuration-experimental-support)
  - [Installing a plugin](#installing-a-plugin)
- [How to use Graph Buddy](#how-to-use-graph-buddy)
  - [Opening Graph Buddy window](#opening-graph-buddy-window)
  - [Basic flow](#basic-flow)
    - [Indexing the graph](#indexing-the-graph)
    - [Navigating through the project](#navigating-through-the-project)
    - [Graph Buddy interactions](#graph-buddy-interactions)
  - [Graph Buddy features](#graph-buddy-features)
    - [Code editor](#code-editor)
    - [Webview](#webview)
- [Roadmap](#roadmap)
- [Contact us](#contact-us)

---
# Supported languages

⚠ Graph Buddy is an experimental project and currently supports only:

- Scala language - via scalac compiler plugin [see](#your-project-configuration) (70% completeness)
- TypeScript language - initial experimental support (20% completeness)

# Installing and configuring the extension

1. VSCode plugin - extension downloadable from VSCode store
2. IntelliJ plugin - extension downloadable from IntelliJ store

To make it work, you need to:

1. Configure your project
2. Install the plugin in your IDE

## Your project configuration

Graph Files will be generated during the compilation and stored in `.semanticgraphs` folder.

### Scala configuration

The only requirement is the scalac compiler plugin. Configuration for sbt:
```
resolvers += Resolver.bintrayRepo("virtuslab", "graphbuddy")
addCompilerPlugin("com.virtuslab.semanticgraphs" % "scalac-plugin" % "0.2.2" cross CrossVersion.full)
scalacOptions += "-Yrangepos"
```

### TypeScript configuration (experimental support)

Typescript data will be generated based on project configuration defined in `tsconfig.json`:

⚠ Currently you can play with Typescript but keep in mind that it is still under active development. There is a lot of work yet to be done to cover all unhandled currently cases. We recommend using a Graph Buddy [ts-example](https://github.com/VirtusLab/graphbuddy/tree/master/ts-example) demonstration repo as a playground.

## Installing a plugin

Make sure you have the following installed:
- [JDK version 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)

The plugin is available for:
- VSCode [here](https://marketplace.visualstudio.com/items?itemName=virtuslab.graph-buddy)
- IntelliJ [here](https://plugins.jetbrains.com/plugin/13467-graph-buddy)

You can install the plugin directly in your IDE - simply navigate to store inside your IDE and search for `Graph Buddy`.

---

# How to use Graph Buddy

Graph Buddy plugin adds a special view into your IDE.
You can perform visual operations, both clicking on your code and on the graph visualization. Doing so will modify the graph structure accordingly, showcasing semantics info about your project.

## Opening Graph Buddy window

**IntelliJ**

Look after a 'GraphBuddy' tab in the bottom right corner and press it.

![Graph Buddy User flow](assets/images/gifs/extension-1-openwebview-intellij.gif)

**VSCode**

Click `GraphBuddy` icon in the activity bar (left), then press the `Open Graph Buddy window` button.
It should open up a new window with an extension ready to use!

![Graph Buddy User flow](assets/images/gifs/extension-1-openwebview-vscode.gif)

## Basic flow

### Indexing the graph

Before doing any operations with the plugin, you have to reindex semantic graph with one of the following options:

- `Reindex graph` - recommended reindexing option (clear and reindex)
- `Reindex graph (add mode)` - only reindexing (without clearing), allowing to reindex multiple projects

*Note:* In Intellij and VSCode it will be reindexed automatically when opening the project

To reindex graph with one of the above, follow these steps in your IDE:

- VSCode - click desired reindex option in the activity bar (left).
- IntelliJ - search for 'Graph Buddy' in the navigation menu and in the dropdown select "Reindex Semantic Graph"

### Navigating through the project

When clicking on code, Graph Buddy will add data accordingly to your code. Each semantic type in your code is represented as *node* and the connection between them as an *edge*. When navigating, the graph will progressively get bigger, showing all the semantic connections inside your project.

![Graph Buddy User flow](assets/images/gifs/extension-2-basicflow.gif)

### Graph Buddy interactions

You can perform several interactions on the Graph Buddy panel, that will help you understand the project semantics better. Choose between a range of features like find a path between nodes, show history of last clicked elements, change pointing edges direction, filter by node kind, and many more!

![Graph Buddy User flow](assets/images/gifs/2d-interface-5-findpath_select.gif)
![Graph Buddy User flow](assets/images/gifs/2d-webview-6-edgesmode.gif)
![Graph Buddy User flow](assets/images/gifs/2d-webview-7-hoverinfo.gif)

## Graph Buddy features

### Code editor

**Tree view container (VSCode)**

1. By clicking Graph Buddy icon in the tree view container (left-side menu) you can enable the extension for current session. It opens up a panel, that contains basic and advanced Graph Buddy options.
2. `Graph options` tree view contains commands that interact with data creation (e.g. reindexing options) and graph generation (e.g. show graph for file).

**Advanced queries tree view (VSCode)**

1. `Advanced queries` tree view allows you to write custom queries in SQL language.
2. Via code lenses in Graph Buddy .sql file you can run the query. The result is presented as graph visualization or in a JSON file.
3. Advanced queries editor saves query files locally in `.graphbuddy` folder and you can manage them (create / rename / delete) directly from the editor.

**TextEditor**

1. When clicking inside a text editor, corresponding nodes and connected to it edges will be highlighted
2. By right-clicking on a text editor or by browsing through commands in activity bar, you can choose from a range of available commands that can help you visualize your project.

### Webview

1. By clicking on nodes, the graph will highlight corresponding nodes and edges
2. By clicking on edges that contain a *reference* parameter, IDE focuses on code responsible for both nodes connected by clicked edge.
3. By shift-clicking node, you remove it from the webview
4. By double-clicking on the node, you extend the graph by adding data corresponding with clicked node
5. By switching layout in the navigation bar, you change the rendering method of the graph (classic, vertical, horizontal)
6. By selecting and unselecting `Graph return level` checkboxes, you filter out corresponding nodes by kind.
7. By checking / unchecking `Inward edges` checkbox, you switch between edges modes: inward and outward (edges pointing in or out)
8. `Show non-browsable nodes` checkbox allows you to filter out nodes not directly defined in your source code (e.g. external dependencies, definitions generated by compiler)
9. When hovering on a node or edge, a tooltip shows up with available data object info
10. When using mouse scroll wheel, you either zoom in or out
11. Pressing `:` opens up a CLI, that works like a *fuzzy search*, searching through network data nodes/edges and their params
12. Right clicking on node or edge opens up a context menu that contains useful options

**Interface buttons**

1. 3D Switcher - a network switcher, changing network manager between 2d and 3d graph (VSCode only!)
2. Freeze button (lock icon) - freezes current graph, not allowing to extend it with data or remove data (filtering level still works)
3. Display history (book icon) - displays history of up to last clicked nodes
4. Clean data (trash icon) - clears network data
5. Find path (two connected dots icon) - opens up a modal that allows to select two nodes, then upon accepting, it highlights path between these two nodes
6. Refresh graph (refresh icon) - refresh graph by redrawing all nodes and edges
7. Network config (gears icon) - opens up a modal that allows you to customize network filtering options

**... and extra interface icons in 2d manager:**

1. Arrow icons - helps to navigate up/down/left/right through graph
2. Zoom in/out icons - zooms graph in/out
3. Reset zoom (magnifying glass icon) - resets graph zoom

---

# Roadmap

**Release**

- [x]  Semantic Graph extraction based on [semanticdb](https://scalameta.org/docs/semanticdb/guide.html) and [Scala Tree (AST)](https://scalameta.org/docs/trees/guide.html)
- [x]  Graph operations available directly via UI
- [x]  Features improving graph usability
- [x]  Improving semantic graph correctness
- [x]  Embedding the solution to Intellij and VSCode
- [x]  Automatically refreshing the graph on code change
- [x]  Introducing IDE plugin configuration
- [x]  Plug-and-play VSCode server
- [x]  Plug-and-play Intellij server
- [x]  Basic Typescript integration

**Future versions**

- [ ]  Getting feedback and implementing most requested features
- [ ]  Integrating the project with Context Buddy
- [ ]  Improving TypeScript support
- [ ]  Introducing JCEF protocol for IntelliJ plugin and fixing several webview issues.

---

# Contact us

We are happy to get any feedback, that could improve our project!
If you want to help/ask questions, feel free to contact us: `graphbuddy@virtuslab.com`
