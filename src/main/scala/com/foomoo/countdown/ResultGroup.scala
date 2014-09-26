package com.foomoo.countdown

class ResultGroup(results: Seq[NumberResult]) {

  def applyOps(ops: Seq[NumberOperation]) = {
    for (a <- results.indices; b <- results.indices; op <- ops; if (b > a)) yield applyOp(a, b, op)
  }

  def applyOp(a: Int, b: Int, op: NumberOperation): ResultGroup = {
    val otherResults = results.zipWithIndex.filter { case (x, i) => i != a && i != b }.map { case (x, i) => x }
    val newResult = op.applyOp(results(a), results(b))
    new ResultGroup(newResult +: otherResults)
  }
  
  override def toString(): String = {
    results.map(nr => nr.result).toString
  }
}

object ResultGroup {
  def apply(results: Int*) = new ResultGroup(results map { NumberResult(_, null, null, null) })
}