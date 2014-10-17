package com.foomoo.countdown

/**
 * Represents an operation that can be applied to a pair of NumberResults, resulting in an Option[NumberResult].
 * The Option will be a None in cases where the NumberResult would result in a value less than 1 or could not be
 * executed in the first place - i.e. divide by zero.
 *
 * The reason for excluding negative results is to prevent final results which are a little difficult to read. For
 * example: (2 - (5 - (6 * 3))) = 15.
 *
 * If negative NumberResults are disallowed the above solution won't occur, but we can still be confident that
 * the solution ((6 * 3) - 5) + 2 will still be found. We've just reduced the number of solutions, and reduced
 * the search space.
 */
abstract class NumberOperation {
  def applyOp(a: NumberResult, b: NumberResult): Option[NumberResult]
  def packageResult(result: Int, a: NumberResult, b: NumberResult, op: NumberOperation): Option[NumberResult] = result match {
    case _ if result < 1 => None
    case _ => Some(NumberResult(result, a, b, op))
  }
}

case class Plus() extends NumberOperation {
  def applyOp(a: NumberResult, b: NumberResult): Option[NumberResult] = packageResult(a.result + b.result, a, b, this)
}

case class Minus() extends NumberOperation {
  def applyOp(a: NumberResult, b: NumberResult): Option[NumberResult] = packageResult(a.result - b.result, a, b, this)
}

case class Product() extends NumberOperation {
  def applyOp(a: NumberResult, b: NumberResult): Option[NumberResult] = packageResult(a.result * b.result, a, b, this)
}

case class Division() extends NumberOperation {
  def applyOp(a: NumberResult, b: NumberResult): Option[NumberResult] =
    if ((a.result % b.result) == 0) packageResult(a.result / b.result, a, b, this)
    else None
}