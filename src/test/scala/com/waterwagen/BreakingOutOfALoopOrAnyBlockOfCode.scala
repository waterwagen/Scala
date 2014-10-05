package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._
import scala.util.control.Breaks._

object BreakingOutOfALoopOrAnyBlockOfCode extends App
{
	breakable
	{
		for(i <- 1 to 10)
		{
			if(i > 5)
				break
			println(i); 
		}
			
	}
}