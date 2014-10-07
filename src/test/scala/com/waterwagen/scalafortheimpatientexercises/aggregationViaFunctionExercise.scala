package com.waterwagen

object AggregationViaFunctionExercise extends App {

  val testString = "Hello"

  // first way - straightforward function with for loop
  def unicodeProduct(string: String) = {
    var charProduct: Long = 1
    for (char <- string) {
      charProduct *= char.toInt
    };
    charProduct
  }

  println(unicodeProduct(testString))

  // second way - recursive function
  def unicodeProductRecursive(string: String, charProduct: Long = 1): Long = {
    if (string.length == 0) {
      return 1
    }
    string.head.toInt * unicodeProductRecursive(string.drop(1))
  }

  println(unicodeProduct(testString))

  // third way - straightforward functional programming
  def seqOp(charProduct: Long, char: Char) = charProduct * char.toInt

  def comboOp(charProduct1: Long, charProduct2: Long) = charProduct1 * charProduct2

  println(testString.aggregate(1L)(seqOp, comboOp))

  // fourth way - succint functional programming
  println(testString.aggregate(1L)(_ * _, _ * _))
}
