package com.waterwagen

import java.util.{HashMap => JavaHashMap}

import scala.collection.JavaConversions._
import scala.collection.mutable._

object RenamedJavaHashMapToScalaHashMapCopyExercise extends App {
  val javaHashMap: JavaHashMap[String, Int] = new JavaHashMap[String, Int]
  javaHashMap.put("key1", 1)
  javaHashMap.put("key2", 2)
  val scalaHashMap = new HashMap[String, Int]
  val translatedJavaHashMap = javaHashMap
  scalaHashMap ++= translatedJavaHashMap
  printf("scala hash map = %s", scalaHashMap)
}
