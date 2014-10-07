// Scala
import scala.collection.mutable._
import scala.collection.JavaConversions._
import scala.math._
import scala.reflect._
import scala.util._
// Java
import java.awt.Point

object Origin extends Point {
  
  def convertUnits(miles : Int) = {
    miles * 1.67
  }

}

printf("Location of origin is %f,%f", Origin.getX, Origin.getY)
Origin.move(-10, 230)
printf("\nLocation of origin is %f,%f", Origin.getX, Origin.getY)

