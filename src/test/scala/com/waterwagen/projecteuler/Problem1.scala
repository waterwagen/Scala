package com.waterwagen.projecteuler

import scala.annotation.tailrec

import com.waterwagen.util.Utils._

object Problem1 extends App {

  val maxNumber : Int = 1000

  def isMultipleOf3Or5(num: Int): Boolean = {
    num % 3 == 0 || num % 5 == 0
  }

  trait Problem1Solution {
    def answer() : Int

    def solutionName() : String = this.getClass.getSimpleName
  }

  class StraightforwardSolution extends Problem1Solution {
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

  class TailRecursiveSolution extends Problem1Solution {
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

  class RecursiveSolution extends Problem1Solution {
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

  class ImmutableNonRecursiveSolution extends Problem1Solution {
    override def answer(): Int = {
      def threeOrFiveFactorValuesUntilMaxNumber() : List[Int] = {
        val numRange : List[Int] = List.range(0, maxNumber)
        for (num <- numRange if isMultipleOf3Or5(num)) yield num
      }

      threeOrFiveFactorValuesUntilMaxNumber().sum
    }
  }

  class FunctionalSolution extends Problem1Solution {
    override def answer(): Int = {
      List.range(0, maxNumber).map(num => if(isMultipleOf3Or5(num)) { num } else { 0 } ).sum
    }
  }

  val solutions : List[Problem1Solution] = List(new StraightforwardSolution,
                                                new TailRecursiveSolution,
                                                new RecursiveSolution,
                                                new ImmutableNonRecursiveSolution,
                                                new FunctionalSolution)
  solutions.foreach(p => printf("%s: total until %d is %d\n\n", p.solutionName, maxNumber, time(p.answer)))
}

