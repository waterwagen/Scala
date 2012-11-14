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

object CaseMatching extends App 
{
	def numToPower(num : Double, power : Int) : Double =
	{
		case class PositiveEven()
		case class PositiveOdd()
		case class Negative()
		case class Zero()
		val power_case = power.signum match
		{ 
			case 0 	=> Zero
			case 1 	=> if(power % 2 == 0) PositiveEven else PositiveOdd
			case -1 => Negative
		}
		power_case match
		{
			case Zero => 1
			case PositiveEven => { val result = numToPower(num, power/2); result * result }
			case PositiveOdd => { val result = numToPower(num, power - 1); num * result }
			case Negative => 1/numToPower(num, power * -1)
		}
//		power.signum match
//		{
//			case 0 => 1
//			case -1 => 1/numToPower(num, power * -1)
//			case 1 => if(power % 2 == 0) { val result = numToPower(num, power/2); result * result }
//						else{ val result = numToPower(num, power - 1); num * result }
////			case _ => println("Unknown message type received.")
//		}
	}	
	assertThat(numToPower(2,4), is(equalTo(16.0)))
	assertThat(numToPower(3,-2), is(equalTo(Math.pow(3,-2))))
	assertThat(numToPower(20,7), is(equalTo(Math.pow(20,7))))	
	assertThat(numToPower(12,34), is(equalTo(Math.pow(12,34))))
}