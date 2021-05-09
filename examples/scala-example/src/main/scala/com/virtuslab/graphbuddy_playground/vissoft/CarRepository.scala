package com.virtuslab.graphbuddy_playground.vissoft

case class Car(name: String) {
  def start(): Unit = println(s"Starting engine $name")
  def stop(): Unit = println(s"Stopping engine $name")
}
trait CarRepository {
  def getCarByName(name: String): Car
}
class CarRepositoryImpl extends CarRepository {
  def getCarByName(name: String): Car = Car(name)
}
