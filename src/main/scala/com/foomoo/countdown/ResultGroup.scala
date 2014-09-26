package com.foomoo.countdown

class ResultGroup(results: Seq[NumberResult]) {

  def applyOps(ops: Seq[NumberOperation]) = {
    (for (a <- results.indices; b <- results.indices; op <- ops; if (b != a)) yield applyOp(a, b, op)).flatten.toSet
  }

  def applyOp(a: Int, b: Int, op: NumberOperation) = {
    val otherResults = results.zipWithIndex.filter { case (x, i) => i != a && i != b }.map { case (x, i) => x }
    if (op.canApplyTo(results(a), results(b))) {
      val newResult = op.applyOp(results(a), results(b))

      Option(new ResultGroup(newResult +: otherResults))

    } else Option.empty
  }

  override def toString(): String = {
    results.map(_.result).toString
  }

  override def hashCode() = results.map(_.result).sorted.hashCode

  override def equals(that: Any): Boolean = that match {
    case that: ResultGroup => (that canEqual this) && (this sameElements that)
    case _ => false
  }


  def canEqual(that: Any): Boolean

}

object ResultGroup {
  def apply(results: Int*) = new ResultGroup(results map { NumberResult(_, null, null, null) })
}