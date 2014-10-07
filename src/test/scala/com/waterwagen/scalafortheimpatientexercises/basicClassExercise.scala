package com.waterwagen

// Scala

// Java

object BasicClassExercise extends App {

  class Counter(private var counter: Int = 0) {
    def ++ {
      if (counter == Int.MaxValue) {
        counter = -1
      };
      counter += 1
    }

    def count = counter
  }

  val counter = new Counter(Int.MaxValue)
  printf("This is the initial counter %d", counter.count)
  counter.++
  printf("\nThis is the incremented counter %d", counter.count)
}
