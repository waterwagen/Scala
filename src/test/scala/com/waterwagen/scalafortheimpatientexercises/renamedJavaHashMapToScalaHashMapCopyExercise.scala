// Scala
//import scala.collection.mutable._
import scala.collection.JavaConversions._
//import scala.math._
//import scala.reflect._
//import scala.util._
// Java
// Mine
import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable._

val javaHashMap : JavaHashMap[String,Int] = new JavaHashMap[String,Int]
javaHashMap.put("key1", 1)
javaHashMap.put("key2", 2)
val scalaHashMap = new HashMap[String,Int]
val translatedJavaHashMap = javaHashMap
scalaHashMap ++= translatedJavaHashMap
printf("scala hash map = %s", scalaHashMap)
