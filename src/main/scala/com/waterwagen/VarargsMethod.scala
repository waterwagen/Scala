package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._
import scala.collection.mutable.HashSet
import scala.collection.mutable.Set

import org.junit.Assert._
import org.junit.Before

import org.hamcrest.Matchers._
import org.hamcrest.MatcherAssert.assertThat

import com.waterwagen.LinkedListBuilder._

object VarargsMethod extends App 
{
	def code_block(strs : String*) = 
	{
		for(str <- strs)
			println(str)
	}
	code_block("1","2","3")
	code_block("10","11","12","13","14")
}