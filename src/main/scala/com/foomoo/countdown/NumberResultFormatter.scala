package com.foomoo.countdown

/**
 * Provides formatting NumberResult objects, including the path to derive their results.
 */
object NumberResultFormatter {

  def format(nr: NumberResult): String = nr match {
    case NumberResult(nrRes, null, null, _) => s"$nrRes"
    case NumberResult(res, nrA, nrB, nrOp) => "(" + format(nrA) + formatOp(nrOp) + format(nrB) + ")"
  }

  def formatOp(nrOp: NumberOperation): String = nrOp match {
    case Plus() => " + "
    case Minus() => " - "
    case Product() => " * "
    case Division() => " / "
  }
}