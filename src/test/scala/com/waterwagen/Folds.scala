package com.waterwagen

import scala.collection.JavaConversions._
import scala.collection.mutable.LinkedList

object Folds extends App {
  val java_props: scala.collection.mutable.Map[String, String] = java.lang.System.getProperties()

  // finding a max; fold sets the result value to the latest value returned from the parameter function
  val folded_longest_key_length = (0 /: java_props)((result: Int, kv: (String, String)) => if (kv._1.length > result) kv._1.length(); else result)
  printf("Longest key length by fold is %s.\n", folded_longest_key_length)

  // transforming a list of numbers
  val orig_list = List(1, 2, 3, 4, 5)
  val multipled_list = (new LinkedList[Int]() /: orig_list)((list: LinkedList[Int], num: Int) => list :+ (num * 2))
  printf("Original:\t %s\n", multipled_list)
  val cleaner_multipled_list = (new LinkedList[Int]() /: orig_list)(_ :+ _).map(_ * 2)
  printf("Cleaner:\t %s\n", cleaner_multipled_list)
  val verbose_multipled_list = orig_list.foldLeft(new LinkedList[Int]())((list: LinkedList[Int], num: Int) => list :+ (num * 2))
  printf("Verbose:\t %s\n", verbose_multipled_list)

  // sum a list of numbers
  val sum = (0 /: (0 to 10))(_ + _)
  printf("Sum of 0 to 10 is %s\n", sum)
}