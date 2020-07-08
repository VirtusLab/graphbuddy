package com.virtuslab.graphbuddy_playground.reference

import scala.reflect.ClassTag

object GBTypes {
  def typedMethod(parameter: String): List[GBClass] = {
    List(new GBClass(parameter))
  }

  def classOfTest(w: Map[String, Int]): Unit = {
      methodInPackageObject(param = "a")
  }

  class PrivateInnerTypedClass[E: ClassTag](enum: E) //TODO
  new PrivateInnerTypedClass[String]("a")
}
