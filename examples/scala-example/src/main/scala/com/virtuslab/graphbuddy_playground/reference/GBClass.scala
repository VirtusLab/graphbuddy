package com.virtuslab.graphbuddy_playground.reference

class GBClass(gbField: String) {
    
  case class GBInnerCaseClass()

  def helloGraphBuddyMessage(prefix: String): String = {
    s"$prefix HelloGraphBuddy"
  }

  private class GBInnerPrivateClass(param: String)
}
