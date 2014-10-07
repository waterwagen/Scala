package com.waterwagen

import scala.collection.mutable._
import scala.collection.JavaConversions._
import scala.math._
import scala.reflect._
import scala.util._

object SimpleObjectExercise extends App {

  object Conversions {

    def inchesToCentimeters(inches: Int) = {
      inches * 2.2
    }

    def gallonsToLiters(gallons: Int) = {
      gallons * 2.1
    }

    def milesToKilometers(miles: Int) = {
      miles * 1.67
    }

  }

  val inches = 5
  printf("%d inches == %f centimeters", inches, Conversions.inchesToCentimeters(inches))
  val gallons = 7
  printf("\n%d gallons == %f liters", gallons, Conversions.gallonsToLiters(gallons))
  val miles = 2
  printf("\n%d miles == %f kilometers", miles, Conversions.milesToKilometers(miles))
}
