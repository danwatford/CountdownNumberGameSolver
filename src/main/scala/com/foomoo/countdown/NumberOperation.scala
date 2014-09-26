package com.foomoo.countdown

abstract class NumberOperation {
  def applyOp(a: NumberResult, b: NumberResult): NumberResult
  def canApplyTo(a: NumberResult, b: NumberResult) = true
}

case class Plus() extends NumberOperation {
  def applyOp(a: NumberResult, b: NumberResult): NumberResult =
    new NumberResult(a.result + b.result, a, b, this)
}

case class Minus() extends NumberOperation {
  def applyOp(a: NumberResult, b: NumberResult): NumberResult =
    new NumberResult(a.result - b.result, a, b, this)
}

case class Product() extends NumberOperation {
  def applyOp(a: NumberResult, b: NumberResult): NumberResult =
    new NumberResult(a.result * b.result, a, b, this)
}

case class Division() extends NumberOperation {
  def applyOp(a: NumberResult, b: NumberResult): NumberResult =
    new NumberResult(a.result / b.result, a, b, this)
  override def canApplyTo(a: NumberResult, b: NumberResult) = (a.result % b.result) == 0
}