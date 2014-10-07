package com.waterwagen

import com.horstmann.random._

object RandomPackageObjectExercise extends App {
  for (i <- 1 to 10) {
    printf("\nrandom int = %d", nextInt)
  }
  setSeed(18)
  for (i <- 1 to 10) {
    printf("\nrandom double = %f", nextDouble)
  }
}
