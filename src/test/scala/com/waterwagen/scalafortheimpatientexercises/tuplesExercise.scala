package com.waterwagen

// Scala
import scala.collection.mutable._
import scala.util._
import scala.collection.JavaConversions._
import scala.math._
// Java

object TuplesExercise extends App {
  def arrayAsString(array: Array[_ <: Any]) = {
    array.mkString("[", ",", "]")
  }

  def findMinMax(values: Array[Int]): (Int, Int) = {
    return values.foldLeft((Int.MaxValue, -1))((minmax, num) => (min(minmax._1, num), max(minmax._2, num)))
  }

  def findLtEqGt(values: Array[Int], pivot: Int) = {
    var lt, eq, gt = 0
    for (num <- values) {
      if (num < pivot) {
        lt += 1
      }
      else if (num == pivot) {
        eq += 1
      }
      else {
        gt += 1
      }
    }
    (lt, eq, gt)
  }

  // exercise functions:
  val values = Array(34, 5, 56, 1, 12, 19)

  // exercise findMinMax function
  val minmax = findMinMax(values)
  printf("\nIn the array %s, the min is %d and the max is %d", arrayAsString(values), minmax._1, minmax._2)

  // exercise findLtEqGt function
  val pivot = 19
  val ltEqGt = findLtEqGt(values, pivot)
  printf("\nIn the array %s, for pivot value %d: lt=%d, eq=%d, gt=%d", arrayAsString(values), pivot, ltEqGt._1, ltEqGt._2, ltEqGt._3)
}
