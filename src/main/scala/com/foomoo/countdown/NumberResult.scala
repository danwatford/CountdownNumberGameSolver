package com.foomoo.countdown

/** A number result is the result of applying operations to a pair of other NumberResult objects. */
case class NumberResult(val result: Int, opA: NumberResult, opB: NumberResult, op: NumberOperation) {

}

object NumberResult {
  def apply(result: Int) = new NumberResult(result, null, null, null)
}