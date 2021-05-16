# Say hello to Graph Buddy!

## Your new best pal to help you understand your Scala code better

With today's IDEs, we are all forced to browse code written as text in flatly-structured files, with almost no information about the semantic dependencies between particular code units.
What if we could take a different look and, instead of seeing just source code in text files, go through colorful graph nodes that instantly and clearly show you dependencies and other essential structural bits extracted from your codebase?

## How can Graph Buddy help you?

Graph Buddy aims to speed up your process of reading and learning about source codes. The Graph Buddy plugin provides a set of useful features and techniques that will help you easily browse through twisted code dependencies. At the same time, it gives you a better understanding of the code structure in your codebase.

## How does it work?

During compilation Graph Buddy extracts additional project metadata - Semantic Code Graph files (stored in `.semanticgraphs` folder). These files are consumed and visualized as an interactive graph in the Graph Buddy plugin.

![Graph Buddy User flow](assets/gifs/extension-preview.gif)

---

# Table of Contents

- [Say hello to Graph Buddy!](#say-hello-to-graph-buddy)
  - [Your new best pal to help you understand your Scala code better](#your-new-best-pal-to-help-you-understand-your-scala-code-better)
  - [How can Graph Buddy help you?](#how-can-graph-buddy-help-you)
  - [How does it work?](#how-does-it-work)
- [Table of Contents](#table-of-contents)
- [Supported languages](#supported-languages)
- [Installing and configuring the extension](#installing-and-configuring-the-extension)
  - [Your project configuration](#your-project-configuration)
    - [Scala configuration](#scala-configuration)
    - [TypeScript configuration (experimental support)](#typescript-configuration-experimental-support)
  - [Installing a plugin](#installing-a-plugin)
- [How to use Graph Buddy](#how-to-use-graph-buddy)
  - [Opening the Graph Buddy board](#opening-the-graph-buddy-board)
    - [IntelliJ](#intellij)
    - [VSCode](#vscode)
    - [Indexing the graph](#indexing-the-graph)
  - [Graph Buddy features](#graph-buddy-features)
    - [List of functionalities](#list-of-functionalities)
    - [Navigating through the project](#navigating-through-the-project)
    - [Context menu in Code Editor](#context-menu-in-code-editor)
    - [Advanced queries (very much experimental)](#advanced-queries-very-much-experimental)
- [Roadmap](#roadmap)
  - [Released](#released)
  - [Planned](#planned)
- [Contact us](#contact-us)

---
# Supported languages

⚠ Graph Buddy is an experimental project and currently only supports:

- Scala language - via scalac compiler [plugin](#your-project-configuration) (70% completed)
- TypeScript language - initial experimental support (20% completed)

# Installing and configuring the extension

To make it work, you need to:

1. Configure your project
2. Install the plugin in your IDE

## Your project configuration

The graph files will be generated during the compilation and stored in `.semanticgraphs` folder.

*Note:* You can play around with Graph Buddy using our scala [example](https://github.com/VirtusLab/graphbuddy/tree/master/examples/scala-example). Just open this project inside your IDE (IntelliJ or VSCode) with the Graph Buddy plugin installed (available via IDE official marketplace).

### Scala configuration

The only requirement is the scalac compiler plugin. 

For sbt you can use sbt plugin. Just create plugin file `project/graphbuddy.sbt` with the content:

```scala
addSbtPlugin("org.virtuslab.semanticgraphs" % "sbt-plugin" % "0.2.12")
```

or add scalac compiler plugin directly:

```scala
addCompilerPlugin("org.virtuslab.semanticgraphs" % "scalac-plugin" % "0.2.12" cross CrossVersion.full)
scalacOptions += "-Yrangepos"
```

Please remember to recompile the project with a new scalac plugin. In sbt:

```bash
sbt clean test:compile
```

Graph Buddy currently supports following scala versions:

- 2.13.5
- 2.13.4
- 2.13.3
- 2.13.2
- 2.13.1
- 2.13.0
- 2.12.13
- 2.12.12
- 2.12.11
- 2.12.10
- 2.12.9
- 2.12.8
- 2.11.12

### TypeScript configuration (experimental support)

Typescript data will be generated based on the project configuration defined in `tsconfig.json`:

⚠ Currently, you can play with Typescript, but keep in mind that it is still under active development. There is a lot of work yet to be done to cover all currently unhandled cases. We recommend using a Graph Buddy [ts-example](https://github.com/VirtusLab/graphbuddy/tree/master/ts-example) demonstration repo as a playground.

## Installing a plugin

Make sure you have the following installed:
- [JDK version 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)

The plugin is available for:

- IntelliJ [here](https://plugins.jetbrains.com/plugin/13467-graph-buddy)
- VSCode [here](https://marketplace.visualstudio.com/items?itemName=virtuslab.graph-buddy)

You can install the plugin directly in your IDE - simply navigate to the store inside your IDE and search for `Graph Buddy`.

---

# How to use Graph Buddy

Graph Buddy plugin adds a unique view into your IDE.
You can perform visual operations, both by clicking on your code or on the graph visualization. Doing so will modify the graph structure accordingly, showcasing semantics info about your project.

## Opening the Graph Buddy board

### IntelliJ

Look for a 'Graph Buddy' tab in the bottom right corner and press it.

![Graph Buddy User flow](assets/gifs/extension-intellij.gif)

### VSCode

Click the `Graph Buddy` icon in the activity bar (left), then press the `Open Graph Buddy window` button.
It will open the Graph Buddy board; just wait for the reindexing process to finish and start browsing!

![Graph Buddy User flow](assets/gifs/extension-vscode.gif)

### Indexing the graph

In Intellij and VSCode the graph will be reindexed automatically during the project startup.

To reindex graph manually:

- VSCode - click the desired reindex option in the activity bar (left).
- IntelliJ - search for 'Graph Buddy' in the navigation menu and in the dropdown select "Reindex".

## Graph Buddy features

### List of functionalities

#### IDE Side

<table>
  <tr>
    <td>Code highlight</td>
    <td>When clicking inside code editor, corresponding nodes and connected to it edges will be highlighted or dynamically added</td>
  </tr>
  <tr>
    <td>Code context menu</td>
    <td>By right-clicking on code, you have an option to render graph for both file and symbol, which will display either full graph per file or all connections for current symbol.</td>
  </tr>
  <tr>
    <td>Reindex menu options</td>
    <td>By clicking 'Reindex graph (*add mode)' in menu bar (IntelliJ) or in left-side panel (VSCode) you index server with newest data with override or *adding to existing data mode</td>
  </tr>
  <tr>
    <td>Codelens</td>
    <td>A codelens (tooltip text) that appears above queries in .sql files in .graphbuddy folder, that allows you to run query and display the result on graph / text</td>
  </tr>
  <tr>
    <td>Theming</td>
    <td>Webview styles change depending on selected IDE theme</td>
  </tr>
</table>

#### Unique to VSCode

<table>
  <tr>
    <td>Side panel</td>
    <td>A Graph Buddy icon should exist on the left side panel of vscode</td>
  </tr>
  <tr>
    <td>Start extension panel button</td>
    <td>In plugin panel window a welcome button exists, thats opens up an extension and changes view to advanced options</td>
  </tr>
  <tr>
    <td>Main panel options</td>
    <td>Panel window contains options such as: reindex options, show graph options, open new Graph Buddy window</td>
  </tr>
  <tr>
    <td>Advanced query editor</td>
    <td>Window that contains all .sql files and allows to add, delete, rename; files are located in '/workspace/.graphbuddy' folder</td>
  </tr>
</table>

#### Webview-side

**NOTE: The base network mode for features is 2d, some features are not/less available on 3d graph.**

#### Graph canvas

<table>
  <tr>
    <td>Graph highlighting</td>
    <td>By clicking on nodes or edges, graph will highlight corresponding nodes and edges</td>
  </tr>
  <tr>
     <td>Graph data styles</td>
     <td>Each data object has its own unique styling</td>
  </tr>
  <tr>
    <td>Removing data</td>
    <td>By shift-clicking node (or choosing option in context menu), you remove it from the webview</td>
  </tr>
  <tr>
    <td>Adding data to the graph</td>
    <td>By double clicking on node you extend the graph by adding data corresponding with clicked node</td>
  </tr>
  <tr>
    <td>Data positioning</td>
    <td>By dragging nodes you position them on the canvas</td>
  </tr>
  <tr>
    <td>Info on hover</td>
    <td>By hovering over node/edge, a popup appears that contains some additional info about targeted data object</td>
  </tr>
  <tr>
    <td>Context menu</td>
    <td>By right clicking on canvas, you open up a context menu with options depending on clicked data: node, edge, data kind or background</td>
  </tr>
  <tr>
    <td>Flash messages</td>
    <td>By performing various actions, flash message will display above interface buttons panel</td>
  </tr>
</table>

#### Navigation bar

<table>
  <tr>
    <td>Filtering options</td>
    <td>By clicking the buttons in filtering menu, you toggle visibility of corresponding node/edge kind</td>
  </tr>
  <tr>
    <td>Layout options</td>
    <td>By switching layout in the navigation bar (layers icon), you change rendering method of the graph (classic, vertical, horizontal)</td>
  </tr>
  <tr>
    <td>Network settings</td>
    <td>By selecting additional network options, you can adjust graph visibility and amount of visible informations to your liking </td>
  </tr>
</table>

#### Interface buttons

<table>
  <tr>
    <td>Switch graph mode</td>
    <td>By clicking switch graph mode button, you change between 2d and 3d network</td>
  </tr>
  <tr>
    <td>Freeze graph</td>
    <td>By clicking freeze graph button, you lock the graph disallowing it to update any data</td>
  </tr>
  <tr>
    <td>Force directed graph</td>
    <td>By clicking force directed graph button, you toggle real-time physics interactions on graph</td>
  </tr>
  <tr>
    <td>Reorganise graph</td>
    <td>By clicking reorganise graph button, you reorganise network nodes positions</td>
  </tr>
  <tr>
    <td>Clear graph</td>
    <td>By clicking clear network data graph button, you clear all existing graph data</td>
  </tr>
  <tr>
    <td>Show click history</td>
    <td>By clicking show history button, you set the graph data to last 10 clicked nodes</td>
  </tr>
  <tr>
    <td>Find path modal</td>
    <td>By clicking find path button, you open up a modal that allows you to find connection and highlight path between selected nodes</td>
  </tr>
  <tr>
    <td>Fuzzy search</td>
    <td>By clicking fuzzy search button (or by pressing ':'), you open up a modal that allows you to search and highlight data based on typed query</td>
  </tr>
  <tr>
    <td>Graph file manager</td>
    <td>By clicking graph file manager button, you open up a modal that allows you to save current graph data snapshot or load it, from a file; default location is /workspace/.graphbuddy</td>
  </tr>
</table>

#### Keyboard shortcuts

<table>
  <tr>
    <td>Revert action</td>
    <td>By pressing 'ctrl+z' you revert last action (add/update/remove/re-position)</td>
  </tr>
  <tr>
    <td>Close modal</td>
    <td>By pressing 'esc' you close any modal currently active</td>
  </tr>
  <tr>
    <td>Fuzzy search</td>
    <td>By pressing ':' open fuzzy search modal</td>
  </tr>
</table>

### Navigating through the project

Each declaration or definition is represented as a *node* and the connection between them as an *edge*. When browsing the code, Graph Buddy will update the graph board interactively. Additionally, by right-clicking in a text editor, you can draw the graph for the whole file unit or for a particular definition.

![Graph Buddy User flow](assets/gifs/extension-flow-1.gif)

You can perform several interactions on the Graph Buddy board to better understand the code structure. Choose between a range of features like: finding a path between nodes; showing the history of last elements clicked; changing pointing edges direction; filtering by node kind, and many more!

![Graph Buddy User flow](assets/gifs/extension-flow-2.gif)
![Graph Buddy User flow](assets/gifs/extension-flow-3.gif)
![Graph Buddy User flow](assets/gifs/extension-flow-4.gif)

#### Advanced queries (very much experimental)

Graph Buddy logic is backed up currently by the OrientDB database. We decided to use this feature to allow users experiment and write custom queries. We believe that it might bring some new interesting feedback and ideas as today's search options in IDE are usually nothing more than advanced `grep`. Searching through the graphs let user construct more advanced searches using the power of semantic data and non-trivial node/edge properties or combinations of both.

As an example, let's say you want to find all the places where some particular library is used in your source code. With graph [SQL dialect](https://orientdb.com/docs/3.0.x/sql/) query, it will simply be:

```sql
SELECT FROM E WHERE in IN (SELECT FROM Node WHERE id LIKE "%org\/your\/library%")
```

or you can narrow down the results to visualize only calls to this library:

```sql
SELECT FROM E WHERE in IN (SELECT FROM Node WHERE id LIKE "%org\/your\/library%") AND @class = "CALL"
```

**Advanced queries tree view (VSCode)**

1. `Advanced queries` tree view allows you to write custom queries in the SQL language.
2. Via code lenses in Graph Buddy .sql file you can run the query. The result is presented as graph visualization or in a JSON file.
3. Advanced queries editor saves query files locally in `.graphbuddy` folder and you can manage them (create/rename/delete) directly from the editor.

---

# Roadmap

## Released

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
- [x]  Getting feedback and implementing most requested features
- [x]  Introducing JCEF protocol for IntelliJ plugin and fixing several webview issues.
- [x]  Further graph browsing improvements and optimizations

## Planned

- [ ]  More plug and play compilations process (eliminating the need for project build definition changes)
- [ ]  Integrating the project with Context Buddy
- [ ]  Improving TypeScript support
- [ ]  Fixing remaining bugs in semantic-graphs scalac compiler plugin

---

# Contact us

We are happy to get constructive feedback that could improve this project!
If you want to help/ask questions, feel free to contact us: `graphbuddy@virtuslab.com`
