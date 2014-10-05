package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._

object CountingDownInAForLoop extends App 
{
	def countdown(num : Int)
	{
		for(i <- num to 0 by -1)
			println(i)
	}
	
	countdown(100)
	
//	assertThat(signumCheck(0), is(equalTo(0)))
//	assertThat(signumCheck(-1), is(equalTo(-1)))
//	assertThat(signumCheck(-1123), is(equalTo(-1)))
//	assertThat(signumCheck(1), is(equalTo(1)))
//	assertThat(signumCheck(3255), is(equalTo(1)))	
}