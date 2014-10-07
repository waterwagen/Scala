package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._

object VarargsMethod extends App {
  def code_block(strs: String*) = {
    for (str <- strs)
      println(str)
  }

  code_block("1", "2", "3")
  code_block("10", "11", "12", "13", "14")
}