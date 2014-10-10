package com.waterwagen.projecteuler.solutions

import com.waterwagen.projecteuler.{ProblemSolution, ProblemSolutionRunner}

import scala.annotation.tailrec

object Problem1Solutions extends App with ProblemSolutionRunner {

  val maxNumber : Int = 1000

  def isMultipleOf3Or5(num: Int): Boolean = {
    num % 3 == 0 || num % 5 == 0
  }

  class StraightforwardSolution extends ProblemSolution[Int] {
    override def answer(): Int = {
      var total : Int = 0
      for(num <- 1 until maxNumber) {
        if(isMultipleOf3Or5(num)) {
          total += num
        }
      }
      total
    }
  }

  class TailRecursiveSolution extends ProblemSolution[Int] {
    override def answer(): Int = {
      @tailrec
      def threeOrFive(num : Int, total : Int): Int = {
        // recursion exit logic
        if(num >= maxNumber) {
          return total
        }

        // calculate the number's value
        val thisValue : Int = if(isMultipleOf3Or5(num)) { num } else { 0 }

        // recurse
        threeOrFive(num + 1, thisValue + total)
      }

      threeOrFive(0, 0)
    }
  }

  class RecursiveSolution extends ProblemSolution[Int] {
    override def answer(): Int = {
      def threeOrFive(num: Int): Int = {
        // recursion exit logic
        if (num >= maxNumber) {
          return 0
        }

        (if (isMultipleOf3Or5(num)) {
          num
        } else {
          0
        }) + threeOrFive(num + 1)
      }

      threeOrFive(0)
    }
  }

  class ImmutableNonRecursiveSolution extends ProblemSolution[Int] {
    override def answer(): Int = {
      def threeOrFiveFactorValuesUntilMaxNumber() : List[Int] = {
        val numRange : List[Int] = List.range(0, maxNumber)
        for (num <- numRange if isMultipleOf3Or5(num)) yield num
      }

      threeOrFiveFactorValuesUntilMaxNumber().sum
    }
  }

  class FunctionalSolution extends ProblemSolution[Int] {
    override def answer(): Int = {
      List.range(0, maxNumber).map(num => if(isMultipleOf3Or5(num)) { num } else { 0 } ).sum
    }
  }

  runSolutions(List(new StraightforwardSolution,
                    new TailRecursiveSolution,
                    new RecursiveSolution,
                    new ImmutableNonRecursiveSolution,
                    new FunctionalSolution))
}

