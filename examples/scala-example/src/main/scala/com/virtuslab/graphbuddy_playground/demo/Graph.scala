package com.virtuslab.graphbuddy_playground.demo

import org.jgrapht._
import org.jgrapht.graph.builder.GraphTypeBuilder

object Graph {
  def emptyGraph(): Graph[String, String] = {
    GraphTypeBuilder
      .directed[String, String]()
      .allowingMultipleEdges(true)
      .allowingSelfLoops(false)
      .edgeClass(classOf[String])
      .buildGraph()
  }
}
