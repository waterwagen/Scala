package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._
import scala.collection.mutable.HashSet
import scala.collection.mutable.Set
import scala.util.control.Breaks._

import org.junit.Assert._
import org.junit.Before

import org.hamcrest.Matchers._
import org.hamcrest.MatcherAssert.assertThat

import com.waterwagen.LinkedListBuilder._

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