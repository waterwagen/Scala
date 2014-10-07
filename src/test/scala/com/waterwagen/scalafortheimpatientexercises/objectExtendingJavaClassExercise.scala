package com.waterwagen

import java.awt.Point

object ObjectExtendingJavaClassExercise extends App {

  object Origin extends Point {

    def convertUnits(miles: Int) = {
      miles * 1.67
    }

  }

  printf("Location of origin is %f,%f", Origin.getX, Origin.getY)
  Origin.move(-10, 230)
  printf("\nLocation of origin is %f,%f", Origin.getX, Origin.getY)
}
