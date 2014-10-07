package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._
import java.io.File

import org.junit.Assert._

import scala.collection.JavaConversions._
import scala.collection.immutable.TreeMap
import scala.collection.mutable.{ArrayBuffer, LinkedHashMap}

object ScalaImpatientChapter4Exercises extends App {
  val origprice_map = Map("iPod" -> 124.59, "iPad" -> 599.95, "MacBook Pro" -> 1195.99)
  val roundToCents = (num: Double) => (num * 100).round.toDouble / 100
  val discountprice_map = origprice_map.mapValues((num: Double) => roundToCents(num * .9))
  val expectedprice_map = Map("iPod" -> 112.13, "iPad" -> 539.96, "MacBook Pro" -> 1076.39)
  assertTrue(discountprice_map == expectedprice_map)

  var mutable_word_map = new scala.collection.mutable.HashMap[String, Int]()
  var in = new java.util.Scanner(new File("./src/test/resources/work_next_steps.txt"))
  while (in.hasNext()) {
    val word = in.next()
    val count = mutable_word_map.getOrElseUpdate(word, 0)
    mutable_word_map(word) = count + 1
  }
  println("-" * 80)
  for ((key, value) <- mutable_word_map)
    printf("word=%s count=%s\n", key, value)

  var immutable_word_map = new scala.collection.immutable.HashMap[String, Int]()
  in = new java.util.Scanner(new File("./src/test/resources/work_next_steps.txt"))
  while (in.hasNext()) {
    val word = in.next()
    val count = immutable_word_map.getOrElse(word, 0) + 1
    immutable_word_map = immutable_word_map + (word -> count)
  }
  println("-" * 80)
  for ((key, value) <- immutable_word_map)
    printf("word=%s count=%s\n", key, value)

  var sorted_word_map: scala.collection.immutable.Map[String, Int] = TreeMap[String, Int]()
  in = new java.util.Scanner(new File("./src/test/resources/work_next_steps.txt"))
  while (in.hasNext()) {
    val word = in.next()
    val count = sorted_word_map.getOrElse(word, 0) + 1
    sorted_word_map = sorted_word_map + (word -> count)
  }
  println("-" * 80)
  for ((key, value) <- sorted_word_map)
    printf("word=%s count=%s\n", key, value)

  val entry_tuple_list = sorted_word_map.toList
  val sorted_entry_tuple_list = entry_tuple_list.sortWith((entry1: (String, Int), entry2: (String, Int)) => entry1._2 < entry2._2)
  println("-" * 80)
  for ((word, count) <- sorted_entry_tuple_list)
    printf("count=%s word=%s\n", count, word)


  val java_word_map: java.util.TreeMap[String, Int] = new java.util.TreeMap[String, Int]()
  in = new java.util.Scanner(new File("./src/test/resources/work_next_steps.txt"))
  while (in.hasNext()) {
    val word = in.next()
    val count = java_word_map.getOrElse(word, 0) + 1
    java_word_map.put(word, count)
  }
  println("-" * 80)
  val java_sorted_word_map = TreeMap[String, Int]() ++ java_word_map
  for ((key, value) <- java_sorted_word_map)
    printf("word=%s count=%s\n", key, value)

  val linked_day_map = LinkedHashMap(("Monday" -> java.util.Calendar.MONDAY),
    ("Tuesday" -> java.util.Calendar.TUESDAY),
    ("Wednesday" -> java.util.Calendar.WEDNESDAY),
    ("Thursday" -> java.util.Calendar.THURSDAY),
    ("Friday" -> java.util.Calendar.FRIDAY),
    ("Saturday" -> java.util.Calendar.SATURDAY),
    ("Sunday" -> java.util.Calendar.SUNDAY))
  println("-" * 80)
  for ((day_name, cal_constant) <- linked_day_map)
    printf("%s is mapped to cal enum with ordinal %s.\n", day_name, cal_constant)

  val java_props: scala.collection.mutable.Map[String, String] = java.lang.System.getProperties()
  val padPositionStr = (end_position: Int, str: String) => " " * (end_position - str.length)
  val line = new StringBuilder()
  val longest_key_length = java_props.maxBy(_._1.length())._1.length() //(kv : (String,String)) => kv._1.length())._1.length()
  printf("Longest key length by maxBy is %s.\n", longest_key_length)
  println("-" * 80)
  for ((prop_name, prop_val) <- java_props) {
    line append prop_name append padPositionStr(longest_key_length + 1, prop_name) append "| " append prop_val
    println(line toString)
    line clear
  }

  // 8.
  println("-" * 80)

  def minMax = (values: Array[Int]) => {
    val min = values.min(Ordering[Int])
    val max = values.max(Ordering[Int])
    (min, max)
  }

  println(minMax(Array(2, 2, 3, 65, 6, 23, 1, 3)))

  // 9.
  println("-" * 80)

  def lteqgt = (values: Array[Int], partition_point: Int) => {
    val sorted_vals = values.sorted(Ordering[Int])
    val lt = sorted_vals.filter(_ < partition_point).length
    val eq = sorted_vals.filter(_ == partition_point).length
    val gt = sorted_vals.filter(_ > partition_point).length
    (lt, eq, gt)
  }

  val partition_buffer = ArrayBuffer(2, 4, 23, 6, 2, 236, 7, 2, 3, 364, 346, 2, 21, 23, 76, 765)
  val partition_point = 236
  printf("Less than, equal to, and greater than counts are %s\nnumber array=%s\npartition point=%s\n",
    lteqgt(partition_buffer.toArray, partition_point),
    partition_buffer.sorted(Ordering[Int]),
    partition_point)

  // 10.
  println("-" * 80)
  //	val words = Array[String]("Hello", "World")
  //	val count = Array[Int](1,1)
  //	val word_count : Map[String,Int] = (Map[String,Int]() /: words.zip(count))(_ + _)
  //	println(word_count)
  val str1 = "abcdefgh"
  val str2 = "abcdefghijklmnopqrstuvwxyz"
  val char_tuples = str1 zip str2
  val equal_prefix_length = char_tuples.length
  println(equal_prefix_length)
}