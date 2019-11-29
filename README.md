# Say hello to Graph Buddy!

## Your new best pal to help you understand your code better

With today’s IDEs we are all forced to browse code by looking at flat file structures, with almost no information about the semantic dependencies between them.What if we could take a look at our code from above and – instead of seeing just text files – go through colorful graph nodes that instantly and clearly show you dependencies and other important bits extracted from your code base?

## How Graph Buddy could help you?

Project allows you to extract abstract semantic graph data from your project, giving you more context about the code.
Graph is augmented with additional useful data and features that will help you better understand connections between code, which will result in lots of saved time - instead of pulling your hair out, trying to understand - you could be doing purposefull, productive stuff.

---

# Table of Contents

1. [Installing and configuring the extension](#installing-and-configuring-the-extension)
    - [Your project configuration](#your-project-configuration)
    - [Setting up the server](#setting-up-the-server)
    - [Installing plugin](#installing-plugin)
2. [How to use Graph Buddy](#how-to-use-graph-buddy)
3. [Roadmap](#roadmap)
4. [Contact us](#contact-us)

---

# Installing and configuring the extension

Graph Buddy extension consist of two parts:
1. Java server - handling all the data
2. IDE plugin - extension downloadable from VSCode & IntelliJ store

To make it work, you need to pass three installation steps:
1. Configure your project
2. Download and set up server
3. Install plugin on your IDE

## Your project configuration

Project heavily relies currently on [semanticb information](https://scalameta.org/docs/semanticdb/guide.html). This data has to be generated during compilation. In your build.sbt add:

```scala
addCompilerPlugin("org.scalameta" % "semanticdb-scalac" % "4.1.9" cross CrossVersion.full)
scalacOptions += "-Yrangepos"
```

and recompile your project.

*NOTE:* If you are using [Scala Language Server Protocol](https://scalameta.org/metals/) (i.e via VSCode) these files will be added there automatically.

## Setting up the server

Make sure you have the following installed:
- [JDK version 11 ](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [sbt](https://www.scala-sbt.org/download.html)

To run the server, download and run following `.jar`
- [Graph Buddy server]()

## Installing plugin

Plugin is available for:
- VSCode
- IntelliJ

Simply navigate to store inside your IDE and search for `Graph Buddy`

---

# How to use Graph Buddy

Graph Buddy plugin embeds a webview window into your IDE.
You can perform visual operations both clicking on your code and on the webview graph. Doing so, will modify the graph structure accordingly, showcasing semantics info about your project.

## Opening webview

**IntelliJ**

Look after a 'GraphBuddy' tab in the bottom right corner and press it.

**VSCode**

Open `Command Palette` and type `> GraphBuddy: Show webview window`

## Basic flow

### Navigating throught project

When clicking on code, Graph Buddy will add data accordingly to your code. Each semantic type in your code is represented as *node* and the connection between them as *edge*. When navigating, the graph will progressively get bigger, showing all the semantic connections inside your project.

### Webview interactions

You can perform several interactions on the webview, that will help you understand the project semantics better. Choose between a range of features like: find path between nodes, show history of last 5 clicked elements, change pointing edges direction, filter by node kind, and many more!

## List of all functionalities

Action | Description | Reaction
--- | --- | ---
--- | --- | ---
--- | --- | ---

---

# Roadmap

**Release**
- [x] Semantic Graph extraction based on [semanticdb](https://scalameta.org/docs/semanticdb/guide.html) and [Scala Tree (AST)](https://scalameta.org/docs/trees/guide.html)
- [x] Graph operations available directly via UI
- [x] Features improving graph usability
- [x] Improving semanticdb graph correctness
- [x] Embedding the solution to Intellij and VSCode
- [x] Automatically refreshing the graph on code change
- [x] Introduce IDE plugin configuration
- [ ] Plug-and-play server

**Future versions**
- [ ] Getting feedback and implementing most requested features
- [ ] Integrating the project with Context Buddy
- [ ] Typescript integration

---

# Contact us

We are happy to get any feedback, that could improve our project!
If you want to help/ask questions, feel free to contact us: `graphbuddy@virtuslab.com`
