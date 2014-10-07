package com.horstmann

package object random {
  import scala.math.pow

  private val a : Int = 1664525
  private val b : Int = 1013904223
  private val n : Int = 32
  private var previousInt : Int = 1
  private var previousDouble : Double = 1

  def nextInt() : Int = {
    previousInt = (previousInt * a) + (b % pow(2, n)).toInt
    previousInt
  }

  def nextDouble() : Double = {
    previousDouble = (previousDouble * a) + (b % pow(2, n))
    previousDouble
  }

  def setSeed(seed : Int) {
    previousInt = seed
    previousDouble = seed
  }
}

