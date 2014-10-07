package com.waterwagen

object WorkingWithTuplesExercise extends App {
  val tuple = ("blah", "again", 4)
  val (first, second, third) = tuple
  printf("first = %s, second = %s, third = %d", first, second, third)
}
