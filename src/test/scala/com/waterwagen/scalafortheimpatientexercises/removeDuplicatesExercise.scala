package com.waterwagen

object RemoveDuplicatesExercise extends App {
  val array = Array(4, 5, 6, 7, 3, 4, 3, 2, 6, 7, 4)
  printf("%s without duplicates is %s", array.mkString("[", ",", "]"), array.distinct.mkString("[", ",", "]"))
}
