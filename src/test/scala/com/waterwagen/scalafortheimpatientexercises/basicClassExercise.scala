// Scala
import scala.collection.mutable._
import scala.util._
import scala.collection.JavaConversions._
import scala.math._
// Java

class Counter(private var counter : Int = 0) {
  def ++ { if(counter == Int.MaxValue) { counter = -1 }; counter += 1 }
  def count = counter
}

val counter = new Counter(Int.MaxValue)
printf("This is the initial counter %d", counter.count)
counter.++
printf("\nThis is the incremented counter %d", counter.count)

