package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers._

object ProductOfCharactersInAString extends App 
{
	def unicodeProductOf(str : String) : Long =
	{
		// solution 1
//		str.foldLeft(1L)((tally : Long, ch : Char) => { tally * ch.longValue()})
		// solution 2
//		var result : Long = 1
//		str.foreach((ch : Char) => {result *= ch.longValue()})
//		result
		// solution 3
//		var result : Long = 1
//		def char_product(ch : Char) = { result *= ch.longValue() }
//		str.foreach(char_product)
//		result
		// solution 4 (recursion)
		if(str.length() == 1)
			str.head.toLong
		else
			str.head.toLong * unicodeProductOf(str.tail)
	}
	
	assertThat(unicodeProductOf("Hello"), is(equalTo(9415087488L)))
//	assertThat(signumCheck(-1), is(equalTo(-1)))
//	assertThat(signumCheck(-1123), is(equalTo(-1)))
//	assertThat(signumCheck(1), is(equalTo(1)))
//	assertThat(signumCheck(3255), is(equalTo(1)))	
}