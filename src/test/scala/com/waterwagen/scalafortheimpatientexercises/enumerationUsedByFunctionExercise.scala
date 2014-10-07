// Scala
import scala.collection.mutable._
import scala.collection.JavaConversions._
import scala.math._
import scala.reflect._
import scala.util._
// Java

object Suit extends Enumeration {

  val HEARTS = Value
  val DIAMONDS = Value
  val CLUBS = Value
  val SPADES = Value

}

def isRed(suit : Suit.Value) = {
  suit == Suit.HEARTS || suit == Suit.DIAMONDS
}

for(suit <- Suit.values) {
  printf("\n%s is red == %b", suit, isRed(suit))
}
