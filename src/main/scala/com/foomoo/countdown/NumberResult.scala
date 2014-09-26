package com.foomoo.countdown
/** A number result is the result of applying operations to a pair of other NumberResult objects. */
class NumberResult(val result: Int, opA: NumberResult, opB: NumberResult, op: NumberOperation) {

  val isRoot = (opA == null)

  override def toString(): String = "" + result
}

object NumberResult {
  def apply(result: Int, opA: NumberResult, opB: NumberResult, op: NumberOperation) = {
    new NumberResult(result, opA, opB, op)
  }
  
  def apply(result: Int) = new NumberResult(result, null, null, null)
}