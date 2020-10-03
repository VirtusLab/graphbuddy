ThisBuild / scalaVersion := "2.13.2"
ThisBuild / organization := "com.virtuslab"

lazy val graphBuddyPlayground = (project in file("."))
  .settings(
    name := "GraphBuddy playground",
    cleanFiles += baseDirectory.value / ".semanticgraphs",
    // https://mvnrepository.com/artifact/org.jgrapht/jgrapht-core
    libraryDependencies += "org.jgrapht" % "jgrapht-core" % "1.5.0",
    addCompilerPlugin(
      "org.scalameta" % "semanticdb-scalac" % "4.3.10" cross CrossVersion.full
    ),
    scalacOptions += "-Yrangepos"
  )
