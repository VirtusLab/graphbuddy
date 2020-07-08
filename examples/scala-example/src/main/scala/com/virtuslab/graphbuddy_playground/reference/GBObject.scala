package com.virtuslab.graphbuddy_playground.reference

trait Param {
  def param: String 
} 

case class GBObject(param: String, param2: String) extends Param

object GBObject extends GBTraitA[Int] {
  def gbMethodInObject(param: String, param2: String): GBObject = new GBObject(param, param2)

  object InnerObject {
    val SomeConstant = 1
  }

  def apply(param1: String, param2: String): Unit = ()
}
