package com.virtuslab.graphbuddy_playground.vissoft

class CarService(carRepository: CarRepository) {
  def startCar(name: String): Unit = {
    val car = carRepository.getCarByName(name)
    car.start()
  }

  def stopCar(name: String): Unit = {
    val car = carRepository.getCarByName(name)
    car.start()
  }
}
