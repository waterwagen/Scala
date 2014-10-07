package com.waterwagen

import scala.collection.mutable.HashSet

object CrackingCodingInterviewProblem1Dot7 extends App {
  val stringValueOf = (matrix: Array[Array[Int]]) => {
    val builder = new StringBuilder()
    for (i <- 0 until matrix.length) {
      builder.append("row").append(" ").append(i).append(": ")
      for (j <- 0 until matrix(0).length)
        builder append matrix(i)(j)
      builder append "\n"
    }
    builder toString
  }

  // setup //
  val row_count = 10;
  val column_count = 7;
  var myMatrix = Array.ofDim[Int](row_count, column_count)
  for (i <- 0 until row_count)
    for (j <- 0 until column_count)
      myMatrix(i)(j) = 5
  myMatrix(1)(3) = 0
  myMatrix(4)(6) = 0
  myMatrix(8)(2) = 0

  println("myMatrix before algorithm:\n" + stringValueOf(myMatrix))

  // algorithm //
  val zero_columns = new HashSet[Int]()
  val zero_rows = new HashSet[Int]()
  for (i <- 0 until myMatrix.length)
    for (j <- 0 until myMatrix(0).length)
      if (myMatrix(i)(j) == 0) {
        zero_rows.add(i)
        zero_columns.add(j)
      }

  for (zero_row <- zero_rows)
    for (i <- 0 until myMatrix(0).length)
      myMatrix(zero_row)(i) = 0

  for (zero_column <- zero_columns)
    for (i <- 0 until myMatrix.length)
      myMatrix(i)(zero_column) = 0

  println("myMatrix after algorithm:\n" + stringValueOf(myMatrix))
}