package com.waterwagen.util

object Utils {

  def time[R](codeToRun : => R) : R = {
    val startTime = System.nanoTime()
    val result = codeToRun
    val endTime = System.nanoTime()
//    println("Elapsed time: " + (endTime - startTime) + "ns")
    println("Elapsed time: " + (endTime - startTime)/1000000.0 + "ms")
    result
  }

}
