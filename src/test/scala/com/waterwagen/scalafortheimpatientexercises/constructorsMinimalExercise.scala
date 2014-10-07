package com.waterwagen

// Scala

// Java

object ConstructorsMinimalExercise extends App {

  class Car(val manufacturer: String,
            val modelName: String,
            val modelYear: Int = -1,
            var licensePlate: String = "") {
  }

  def printCar(car: Car) {
    printf("\nCar is a %d %s %s with plates %s", car.modelYear, car.manufacturer, car.modelName, car.licensePlate)
  }

  var car = new Car("Ford", "Fusion", 2014, "KJM-8422")
  printCar(car)
  car.licensePlate = "AJT-9843"
  printCar(car)
  car = new Car("Chevy", "Cobalt")
  printCar(car)
  car = new Car("Subaru", "Legacy", modelYear = 2011)
  printCar(car)
  car = new Car("Mazda", "Mazda2", licensePlate = "BWE-2901")
  printCar(car)
}
