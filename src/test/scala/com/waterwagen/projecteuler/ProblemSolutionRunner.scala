package com.waterwagen.projecteuler

import com.waterwagen.util.Utils._

trait ProblemSolutionRunner {

  def runSolutions(solutions : List[ProblemSolution]): Unit = {
    solutions.foreach(p => printf("The %s total until %d is %d\n\n", p.solutionName, time(p.answer)))
  }

}
