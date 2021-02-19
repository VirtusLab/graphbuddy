package com.virtuslab.graphbuddy_playground.demo

object Main {
  def nextMax(a: Int, b: Int): Int = {
    val max = if (a >= b) a else b
    max + 1
  }
}
