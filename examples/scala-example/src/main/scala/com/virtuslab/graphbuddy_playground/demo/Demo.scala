package com.virtuslab.graphbuddy_playground.demo

class A() {
  def methodA(): String = "methodA"
}

class B() {
  def methodB(a: A): String = "methodB" + a.methodA()
}
