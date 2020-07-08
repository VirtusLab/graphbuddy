package com.virtuslab.graphbuddy_playground.reference

object GBImplicitClassTest {
  implicit class GBImplicitClass(gbClass: GBClass) {
    def implicitClassMethod(): Unit = ()
  }
  val gbClass = new GBClass("a")
  val gbClass2 = new GBClass("a")

  gbClass.implicitClassMethod()
  gbClass2.implicitClassMethod()
}
