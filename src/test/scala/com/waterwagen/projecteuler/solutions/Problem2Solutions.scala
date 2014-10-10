package com.waterwagen.projecteuler.solutions

import com.waterwagen.projecteuler.{ProblemSolution, ProblemSolutionRunner}

import scala.annotation.tailrec

object Problem2Solutions extends App with ProblemSolutionRunner {

  val maxNumber : Int = 4000000

  class Solution extends ProblemSolution[Int] {

    override def answer() : Int = {

      @tailrec
      def evenFibonacciTotaler(previousPreviousNum : Int,
                               previousNum : Int,
                               total : Int): Int = {
        val currentNum : Int = previousPreviousNum + previousNum

        // recursion exit condition
        if(currentNum > maxNumber) { return total }

        val currentNumValue : Int = if(currentNum % 2 == 0) { currentNum } else { 0 }
        evenFibonacciTotaler(previousNum, currentNum, total + currentNumValue)
      }

      evenFibonacciTotaler(0, 1, 0)
    }

  }

  runSolutions(List(new Solution))

}

