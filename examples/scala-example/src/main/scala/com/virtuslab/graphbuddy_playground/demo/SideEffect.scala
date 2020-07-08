package com.virtuslab.graphbuddy_playground.demo

object SideEffect {
  class State(private var _i: Integer){
      def setState(i: Integer) = _i = 1 
  }
  private var state = new State(1)
  val const = "impure"

  def impureMethod(i: Integer): String = {
      state.setState(i)
      const
  }
}
