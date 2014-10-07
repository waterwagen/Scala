package com.waterwagen

// Scala
import scala.collection.mutable._
import scala.collection.JavaConversions._
import scala.math._
import scala.reflect._
import scala.util._
// Java

object ConstructorsExercise extends App {

  class Car(val manufacturer: String,
            val modelName: String,
            val modelYear: Int,
            var licensePlate: String) {

    def this(manufacturer: String,
             modelName: String,
             modelYear: Int) {
      this(manufacturer, modelName, modelYear, "")
    }

    def this(manufacturer: String,
             modelName: String,
             licensePlate: String) {
      this(manufacturer, modelName, -1, licensePlate)
    }

    def this(manufacturer: String,
             modelName: String) {
      this(manufacturer, modelName, "")
    }

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
  car = new Car("Subaru", "Legacy", 2011)
  printCar(car)
  car = new Car("Mazda", "Mazda2", "BWE-2901")
  printCar(car)
}
