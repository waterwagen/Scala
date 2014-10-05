package com.waterwagen

import scala.collection.mutable.ArrayBuffer

object Recursion extends App 
{
	class Result(sum : Int) { var mSum = sum; def +=(num : Int) {mSum += num}; override def toString() : String = {mSum.toString()} }
	def tailRecursiveAdd(list : ArrayBuffer[Int], result : Result)
	{
		if(list != Nil)
		{
			result += list.head
			tailRecursiveAdd(list.tail,result)
		}
	}
	def headRecursiveAdd(list : ArrayBuffer[Int]) : Int =
	{
		if(list == Nil) 0
		else
		{
			val result = headRecursiveAdd(list.tail)
			val head = list.head
			head + result
		}
		
	}
	
	val list = (new ArrayBuffer[Int]() /: (0 to 10000))(_ += _)
	val tail_result = new Result(0) 
	tailRecursiveAdd(list, tail_result)
	printf("Tail recursive add result=%s\n", tail_result)
	try{printf("Head recursive add result=%s\n", headRecursiveAdd(list))}
	catch 
	{
		//http://oldfashionedsoftware.com/2008/09/27/tail-recursion-basics-in-scala/
		case e:StackOverflowError => println("Stack overflow error caught during head recursion. Tail recursion in Scala has an optimization which avoids this.") 
		case _ => println("unknown exception caught")
	}
}