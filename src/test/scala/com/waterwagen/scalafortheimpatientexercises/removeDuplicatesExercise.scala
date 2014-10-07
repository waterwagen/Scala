import scala.collection.mutable._
import scala.util._

val array = Array(4,5,6,7,3,4,3,2,6,7,4)
printf("%s without duplicates is %s", array.mkString("[", ",", "]"), array.distinct.mkString("[", ",", "]"))

