package com.waterwagen

// Scala
import scala.collection.mutable._
import scala.util._
import scala.collection.JavaConversions._
import scala.math._
// Java

object TimeModerateComplexityClassExample extends App {

  class Time(initHours: Int, initMins: Int) {
    if (initHours < 0 || initHours > 23) {
      throw new IllegalArgumentException("Hours parameter out of range: %d".format(initHours))
    }
    if (initMins < 0 || initMins > 59) {
      throw new IllegalArgumentException("Minutes parameter out of range: %d".format(initMins))
    }

    private val minsSinceMidnight = (initHours * 60) + initMins

    // api
    def hours = minsSinceMidnight / 60

    def mins = minsSinceMidnight % 60

    def before(other: Time): Boolean = {
      return minsSinceMidnight < other.minsSinceMidnight
    }
  }

  val time = new Time(1, 30)
  printf("This is the first time %02d:%02d", time.hours, time.mins)
  val time2 = new Time(13, 8)
  printf("\nThis is the second time %02d:%02d", time2.hours, time2.mins)
  printf("\nFirst time is before second time == %b", time.before(time2))
  printf("\nSecond time is before first time == %b", time2.before(time))
  //val time2 = new Time(24,2) - throws IllegalArgumentException because it is out of range for military hours
}
