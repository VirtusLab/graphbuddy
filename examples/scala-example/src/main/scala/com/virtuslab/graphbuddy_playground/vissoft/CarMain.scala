package com.virtuslab.graphbuddy_playground.vissoft

object CarMain {

  val carRepository = if(1 == 2) new CarRepositoryImpl() else new CarRepositoryImpl2()
  val carService = new CarService(carRepository)
  val http = new CarHttp(carService)
  def simulate(): Unit = {
    http.startCarPost("Fiat126p")
    println("Car is running")
    http.stopCarPost("Fiat126p")
  }

}
