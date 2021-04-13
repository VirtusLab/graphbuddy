ThisBuild / scalaVersion := "2.13.4"
ThisBuild / organization := "com.virtuslab"

lazy val graphBuddyPlayground = (project in file("."))
  .settings(
    name := "GraphBuddy playground",
    // https://mvnrepository.com/artifact/org.jgrapht/jgrapht-core
    libraryDependencies += "org.jgrapht" % "jgrapht-core" % "1.5.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % "test"
  )
