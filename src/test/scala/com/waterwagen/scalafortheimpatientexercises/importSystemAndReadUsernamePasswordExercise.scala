// Scala
//import scala.collection.mutable._
//import scala.collection.JavaConversions._
//import scala.math._
//import scala.reflect._
//import scala.util._
// Java
// Mine
import java.lang.System._

val username = getProperty("user.name")
val password = readLine("Please enter your password: ")
if(password == "secret") 
  out.println(String.format("\nHi %s", username)) 
else 
  err.println("\nYour password is not secret!")

