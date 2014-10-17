package com.foomoo.countdown

object SolutionFinder {

  def findSolutions(target:Int, inputs: Int*): Iterator[NumberResult] = {
    val rootGroup = ResultGroup(inputs:_*)
    
    new ResultGroupIterator(rootGroup).map(_.getMatching(target)).flatten
  }
  
  def findSolution(target:Int, inputs: Int*): Option[NumberResult] = 
    findSolutions(target, inputs:_*).take(1).find(_ => true)
}