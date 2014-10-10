package com.waterwagen.projecteuler

trait ProblemSolution[T] {

  def answer() : T

  def solutionName(): String = this.getClass.getSimpleName
}
