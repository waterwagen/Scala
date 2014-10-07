package com.waterwagen

// Scala

// Java

object EnumerationWithCustomNamesExercise extends App {

  object Suit extends Enumeration {

    val HEARTS = Value(42.toChar.toString)
    val DIAMONDS = Value(43.toChar.toString)
    val CLUBS = Value(44.toChar.toString)
    val SPADES = Value(45.toChar.toString)

  }

  for (suit <- Suit.values) {
    printf("\n%s", suit)
  }
}
