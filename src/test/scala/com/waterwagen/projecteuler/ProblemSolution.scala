package com.waterwagen.projecteuler

trait ProblemSolution {

  def answer(): Int

  def solutionName(): String = this.getClass.getSimpleName
}
