package com.waterwagen

object ObjectApplyToBuildClassInstanceExercise extends App {

  class Point private(val x: Int, val y: Int) {}

  object Point {

    def apply(x: Int, y: Int) = {
      new Point(x, y)
    }

  }

  val point = Point(249, -90)
  printf("Location of point is %d,%d", point.x, point.y)
}
