package com.virtuslab.graphbuddy_playground.vissoft

class CarHttp(carService: CarService) {
  def startCarPost(name: String) = {
    carService.startCar(name)
  }

  def stopCarPost(name: String) = {
    carService.stopCar(name)
  }
}
