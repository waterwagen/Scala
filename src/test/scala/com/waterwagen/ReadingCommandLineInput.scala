package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._

object ReadingCommandLineInput extends App {
  println("Please log in:")
  val username = readLine("Username:")
  val password = readLine("Password:")
  val output = "Your username is %s and your password is %s".format(username, password)
  println(output)
}