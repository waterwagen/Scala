package com.waterwagen

import java.lang.System._

import scala.io.StdIn

object ImportSystemAndReadUsernamePasswordExercise extends App {
  val username = getProperty("user.name")
  val password = StdIn.readLine("Please enter your password: ")
  if (password == "secret")
    out.println(String.format("\nHi %s", username))
  else
    err.println("\nYour password is not secret!")
}
