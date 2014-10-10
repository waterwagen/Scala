package com.waterwagen.projecteuler

import scala.annotation.tailrec

import com.waterwagen.util.Utils._

object Problem1 extends App {

  val maxNumber : Int = 1000

  def isMultipleOf3Or5(num: Int): Boolean = {
    num % 3 == 0 || num % 5 == 0
  }

  class StraightforwardSolution extends ProblemSolution {
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

  class TailRecursiveSolution extends ProblemSolution {
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

  class RecursiveSolution extends ProblemSolution {
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

  class ImmutableNonRecursiveSolution extends ProblemSolution {
    override def answer(): Int = {
      def threeOrFiveFactorValuesUntilMaxNumber() : List[Int] = {
        val numRange : List[Int] = List.range(0, maxNumber)
        for (num <- numRange if isMultipleOf3Or5(num)) yield num
      }

      threeOrFiveFactorValuesUntilMaxNumber().sum
    }
  }

  class FunctionalSolution extends ProblemSolution {
    override def answer(): Int = {
      List.range(0, maxNumber).map(num => if(isMultipleOf3Or5(num)) { num } else { 0 } ).sum
    }
  }

  val solutions : List[ProblemSolution] = List(new StraightforwardSolution,
                                                new TailRecursiveSolution,
                                                new RecursiveSolution,
                                                new ImmutableNonRecursiveSolution,
                                                new FunctionalSolution)
  solutions.foreach(p => printf("The %s total until %d is %d\n\n", p.solutionName, maxNumber, time(p.answer)))
}

