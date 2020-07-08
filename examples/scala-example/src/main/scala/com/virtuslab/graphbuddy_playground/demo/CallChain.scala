package com.virtuslab.graphbuddy_playground.demo

object CallChain {

  def methodA(): Unit = ()

  def methodB(): Unit = methodA()

  def methodC(): Unit = methodB()

  def methodD(): Unit = methodC()

}
