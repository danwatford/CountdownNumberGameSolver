package com.foomoo.countdown

class ResultGroup(val results: Seq[NumberResult]) {

  /**
   * Applies the given sequence of NumberOperations to each pair of NumberResults in this ResultGroup, returning a
   */
  def applyOps(ops: Seq[NumberOperation]): Set[ResultGroup] = {
    (for (a <- results.indices; b <- results.indices; op <- ops; if (b != a)) yield applyOp(a, b, op)).flatten.toSet
  }

  /**
   * Applies the given NumberOperation to the NumberResults in results denoted by the given indexes.
   */
  def applyOp(a_index: Int, b_index: Int, op: NumberOperation): Option[ResultGroup] = {
    // Capture the NumberResults objects not referred to by a_index and b_index.
    val otherResults = results.zipWithIndex.filter { case (x, i) => i != a_index && i != b_index }.map { case (x, i) => x }

    // Apply the operation against the NumberResults, mapping the resulting option to append the 
    // NumberResults not affected by the operation.
    op.applyOp(results(a_index), results(b_index)).map { newResult => new ResultGroup(newResult +: otherResults) }
  }

  def getMatching(target: Int): Option[NumberResult] = {
    results.filter(nr => target == nr.result).headOption
  }

  override def toString(): String = {
    results.map(_.result).mkString("RG(", ",", ")")
  }

  override def hashCode() = results.map(_.result).sorted.hashCode

  override def equals(that: Any): Boolean = that match {
    case that: ResultGroup => (that canEqual this) && (that.hashCode.equals(this.hashCode))
    case _ => false
  }

  def canEqual(that: Any): Boolean = that match {
    case that: ResultGroup => true
    case _ => false
  }

}

object ResultGroup {
  def apply(results: Int*) = new ResultGroup(results map { NumberResult(_, null, null, null) })
}