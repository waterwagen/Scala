package com.waterwagen.projecteuler

import com.waterwagen.util.Utils._

trait ProblemSolutionRunner {

  def runSolutions[T](solutions : List[ProblemSolution[T]]): Unit = {
    solutions.foreach(p => printf("The %s answer is %s\n\n", p.solutionName, time(p.answer)))
  }

}
