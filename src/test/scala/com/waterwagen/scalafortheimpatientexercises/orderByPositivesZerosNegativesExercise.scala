import scala.collection.mutable._
import scala.util._

def orderByPositivesZerosNegatives(a : ArrayBuffer[Int]) {
  val negatives = new ArrayBuffer[Int]()
  val indexesToRemove = new ArrayBuffer[Int]()
  var numberOfZeros = 0
  for(index <- 0 until a.length; num = a(index)) {
    if(num == 0) { numberOfZeros += 1; indexesToRemove.+=:(index) }
    if(num < 0) { negatives += num; indexesToRemove.+=:(index) } // prepend so we can remove items by index without affecting other indexes
  }
  for(index <- 0 until indexesToRemove.length) {
    a remove indexesToRemove(index)
  }
  for(i <- 1 to numberOfZeros) { a.insert(a.length, 0) }
  if(negatives.length > 0) { a.insertAll(a.length, negatives) }
}

// one zero
val a = new ArrayBuffer[Int]() += (3, -5, 8, 0, 16, 22, -95, -100, 2)
val original = a.toBuffer
orderByPositivesZerosNegatives(a)
printf("\n%s ordered by positive, zero, negative:\n%s", original, a)

// no zeros
val a1 = new ArrayBuffer[Int]() += (3, -5, 8, 16, 22, -95, -100, 2)
val original1 = a1.toBuffer
orderByPositivesZerosNegatives(a1)
printf("\n%s ordered by positive, zero, negative:\n%s", original1, a1)

// two zeros
val a2 = new ArrayBuffer[Int]() += (3, -5, 0, 8, 16, 0, 22, -95, -100, 2)
val original2 = a2.toBuffer
orderByPositivesZerosNegatives(a2)
printf("\n%s ordered by positive, zero, negative:\n%s", original2, a2)

