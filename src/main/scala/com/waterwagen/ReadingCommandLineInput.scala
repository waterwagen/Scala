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

object ReadingCommandLineInput extends App 
{
	println("Please log in:")
	val username = readLine("Username:")
	val password = readLine("Password:")
	val output = "Your username is %s and your password is %s".format(username, password)
	println(output)
}