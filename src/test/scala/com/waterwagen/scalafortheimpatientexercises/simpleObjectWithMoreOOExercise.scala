// Scala
import scala.collection.mutable._
import scala.collection.JavaConversions._
import scala.math._
import scala.reflect._
import scala.util._
// Java

abstract class UnitConversion {

  def convertUnits(unit : Int) : Double

}

object InchesToCentimeters extends UnitConversion {
  
  def convertUnits(inches : Int) = {
    inches * 2.2
  }
}

object GallonsToLiters extends UnitConversion {
  
  def convertUnits(gallons : Int) = {
    gallons * 2.1
  }
}

object MilesToKilometers extends UnitConversion {
  
  def convertUnits(miles : Int) = {
    miles * 1.67
  }
}

val inches = 5
printf("%d inches == %f centimeters", inches, InchesToCentimeters.convertUnits(inches))
val gallons = 7
printf("\n%d gallons == %f liters", gallons, GallonsToLiters.convertUnits(gallons))
val miles = 2
printf("\n%d miles == %f kilometers", miles, MilesToKilometers.convertUnits(miles))
