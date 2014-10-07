package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._

object YieldingWithForLoops extends App {
  println(for (ch <- "GdkknVnqkc") yield (ch + 1).toChar)
}