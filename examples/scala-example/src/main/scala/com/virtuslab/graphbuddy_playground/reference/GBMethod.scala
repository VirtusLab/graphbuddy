package com.virtuslab.graphbuddy_playground.reference

object GBMethod {

  def method(parameter: String): GBClass = {
    new GBClass(parameter)
  }

  def method2() = {
    GBObject(
      param1 = "1", 
      param2 = "2"
    )
    GBObject.gbMethodInObject("1", param2 = "s")
  }


  def testIfs(condition: Boolean, a: String, b: String): String = {
    if (condition)
      a
    else
      b
  }

  method(parameter = "namedParameter")
}
