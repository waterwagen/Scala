package com.waterwagen

import scala.collection.mutable._
import scala.collection.JavaConversions._
import scala.math._
import scala.reflect._
import scala.util._

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
