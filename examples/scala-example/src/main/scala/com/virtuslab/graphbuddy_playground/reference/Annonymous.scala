package com.virtuslab.graphbuddy_playground.reference

object Annonymous {
  val HelloWorld = "HelloWorld"
  val annonymous = new GBTraitA[String] {
    def methodA(): String = HelloWorld
  }
}
