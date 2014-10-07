package com.waterwagen

// Scala

// Java

object EnumerationUsedByFunctionExercise extends App {

  object Suit extends Enumeration {

    val HEARTS = Value
    val DIAMONDS = Value
    val CLUBS = Value
    val SPADES = Value

  }

  def isRed(suit: Suit.Value) = {
    suit == Suit.HEARTS || suit == Suit.DIAMONDS
  }

  for (suit <- Suit.values) {
    printf("\n%s is red == %b", suit, isRed(suit))
  }
}
