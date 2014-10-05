package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._
import java.awt.datatransfer._
import java.util.TimeZone

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers._
import org.junit.Assert._

import scala.collection.JavaConversions._
import scala.collection.mutable.{ArrayBuffer, Buffer}
import scala.util.Random

object ScalaImpatientChapter3Exercises extends App 
{
	val num_count : Int = 100
	var arr_buff : ArrayBuffer[Int] = { val result = ArrayBuffer[Int](); for(i <- 1 to num_count) result += Random.nextInt(num_count); result }
	println(arr_buff)
	val tens = for(num <- arr_buff if num % 10 == 0) yield num
	println(tens.sortWith((num1, num2) => num1 < num2))
	
	arr_buff = ArrayBuffer[Int](1,2,3,4,5,6,7)
	for(i <- 1 until arr_buff.length by 2)
	{
		var temp = arr_buff(i - 1)
		arr_buff(i - 1) = arr_buff(i)
		arr_buff(i) = temp
	}
		
	var exp_buff = ArrayBuffer(2,1,4,3,6,5,7)
	assertThat(arr_buff, is(equalTo(exp_buff)))
	println(arr_buff)
	
	val compareIntEquality = (a : Int, b : Int) => a == b
	arr_buff = ArrayBuffer[Int](1,2,3,4,5,6,7,8)
	exp_buff = ArrayBuffer(2,1,4,3,6,5,8,7)
	val findSwapIndex = (index : Int, end_index : Int) => 
						{
							if(index == end_index && end_index % 2 == 0) index
							else if(index % 2 == 0) index + 1
							else index - 1
						}
	val swapper = (arr_buff : ArrayBuffer[Int]) => for(i <- 0 until arr_buff.length; end = arr_buff.length - 1) yield arr_buff(findSwapIndex(i, end))
	var new_seq = swapper(arr_buff)
	println(new_seq)
	assertTrue(new_seq.corresponds(exp_buff)(compareIntEquality))

	arr_buff = ArrayBuffer[Int](1,2,3,4,5,6,7)
	exp_buff = ArrayBuffer(2,1,4,3,6,5,7)
	new_seq = swapper(arr_buff)
	println(new_seq)
	assertTrue(new_seq.corresponds(exp_buff)(compareIntEquality))

	arr_buff = ArrayBuffer[Int](1,0,-2,3,4,-5,6,7)
	exp_buff = ArrayBuffer[Int](1,3,4,6,7,0,-2,-5)
	val partitioned = arr_buff.partition((num : Int) => num > 0)
	val partition_result = partitioned._1 ++ partitioned._2
	println(partition_result)
	assertTrue(partition_result.corresponds(exp_buff)(compareIntEquality))

	val sum_buff = Array(1,2,3,4,5,6)
	val foldSummation = (sum : Int, next_int : Int) => sum + next_int
	val sum = sum_buff./:(0)(foldSummation)
	assertThat(sum, is(equalTo(21)))
	val avg : Double = sum.toDouble/sum_buff.length.toDouble
	assertThat(avg, is(equalTo(3.5)))
	
	var reverse_array = Array(6,2,5,2,6,1)
	val exp_array = Array(6,6,5,2,2,1)
	reverse_array = reverse_array.sortBy((num : Int) => num)
	reverse_array = reverse_array.reverse
	assertTrue(reverse_array.corresponds(exp_array)(compareIntEquality))
	
	var reverse_buff = ArrayBuffer(6,2,5,2,6,1)
	exp_buff = ArrayBuffer(6,6,5,2,2,1)
	reverse_buff = reverse_buff.sortBy((num : Int) => num)
	reverse_buff = reverse_buff.reverse
	println(reverse_buff)
	assertTrue(reverse_array.corresponds(exp_buff)(compareIntEquality))

	exp_buff = ArrayBuffer(6,5,2,1)
	val distinct_buff = reverse_buff.distinct
	println(distinct_buff)
	assertTrue(distinct_buff.corresponds(exp_buff)(compareIntEquality))
	
	val evens = reverse_buff.filter(_ % 2 == 0)
	exp_buff = ArrayBuffer(6,6,2,2)
	println(evens)
	assertTrue(evens.corresponds(exp_buff)(compareIntEquality))
	
	val evens_doubled = reverse_buff.filter(_ % 2 == 0).map(_ * 2)
	exp_buff = ArrayBuffer(12,12,4,4)
	println(evens_doubled)
	assertTrue(evens_doubled.corresponds(exp_buff)(compareIntEquality))
	
	arr_buff = ArrayBuffer[Int](1,0,-2,3,4,-5,6,7,-9)
	var neg_indexes = ArrayBuffer[Int]()
	for(i <- 0 until arr_buff.length if arr_buff(i) < 0)
		neg_indexes += i
	neg_indexes = neg_indexes.reverse
	neg_indexes = neg_indexes.dropRight(1)
	for(i <- 0 until neg_indexes.length)
		arr_buff.remove(neg_indexes(i))
	exp_buff = ArrayBuffer(1,0,-2,3,4,6,7)
	println(arr_buff)
	assertTrue(arr_buff.corresponds(exp_buff)(compareIntEquality))
	
	val am_prefix = "America/"
	val tz_names = TimeZone.getAvailableIDs()
//	println(ArrayBuffer() ++ tz_names)
	val am_tz_names = tz_names.filter(_ startsWith am_prefix)
	val am_tz_names_trimmed : ArrayBuffer[String] = ArrayBuffer() ++ am_tz_names.map(_.drop(am_prefix.length()))
	println(am_tz_names_trimmed)
	
	val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
	val buffer : Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
	println(buffer)
}

//object Sandbox extends App
//{
////	case class TestNode(value : Int, right : TestNode, left : TestNode)
//	def newNodeWithValue(value : Int) : TreeNode = 
//	{
//		TreeNode(value)
//	}
//	
//	val root = newNodeWithValue(9)
//	root.right = newNodeWithValue(12)
//	root.right.right = newNodeWithValue(15)
//	root.right.left = newNodeWithValue(11)
//
//	root.left = newNodeWithValue(8)
//	root.left.right = newNodeWithValue(9)
//	root.left.left = newNodeWithValue(4)
//	
//	root.printTree(4)
//}