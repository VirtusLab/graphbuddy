package com.virtuslab.graphbuddy_playground.reference

import java.util.concurrent.TimeUnit

object Experiments {

  import GBObject._

  val d: List[Int] = List(1, 2, 3)

  def twoDirect: Experiments.type = Experiments

  val s = "GraphBuddy"

  d.map { i => d.map(w => w + 1) }

  d.foreach{ i =>
    new GBClass(s.toString)
  }

  d.foreach { _ =>
    println("Annonymous param")
    TimeUnit.SECONDS
  }

  val z = GBObject.InnerObject.SomeConstant

  d.contains(GBObject.InnerObject.SomeConstant)

  gbMethodInObject("1", param2 = "222")

  GBObject("param", param2 = "param2")

  val qualifiedNameFmt: String = "(" + z + "*)?" + z
}
