// Scala
import scala.collection.mutable._
import scala.collection.JavaConversions._
import scala.math._
import scala.reflect._
import scala.util._
// Java

// this is my first scala application!
object Reverse extends App {
  for(index <- (0 until args.length).reverse) {
    printf("\n%s", args(index))
  }
}

