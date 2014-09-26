package com.foomoo.countdown

object worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val nrl = List(NumberResult(1, null, null, null), NumberResult(10, null, null, null), NumberResult(100, null, null, null))
                                                  //> nrl  : List[com.foomoo.countdown.NumberResult] = List(1, 10, 100)
  
  val rg = ResultGroup(1, 10, 100)                //> rg  : com.foomoo.countdown.ResultGroup = ArrayBuffer(1, 10, 100)
  
  val rgi = new ResultGroupIterator(rg)           //> rgi  : com.foomoo.countdown.ResultGroupIterator = non-empty iterator
 
  rgi.take(50).toList                             //> res0: List[com.foomoo.countdown.ResultGroup] = List(ArrayBuffer(1, 10, 100),
                                                  //|  ArrayBuffer(11, 100), ArrayBuffer(-9, 100), ArrayBuffer(10, 100), ArrayBuff
                                                  //| er(0, 100), ArrayBuffer(101, 10), ArrayBuffer(-99, 10), ArrayBuffer(100, 10)
                                                  //| , ArrayBuffer(0, 10), ArrayBuffer(110, 1), ArrayBuffer(-90, 1), ArrayBuffer(
                                                  //| 1000, 1), ArrayBuffer(0, 1), ArrayBuffer(111), ArrayBuffer(-89), ArrayBuffer
                                                  //| (1100), ArrayBuffer(0), ArrayBuffer(91), ArrayBuffer(-109), ArrayBuffer(-900
                                                  //| ), ArrayBuffer(0), ArrayBuffer(110), ArrayBuffer(-90), ArrayBuffer(1000), Ar
                                                  //| rayBuffer(0), ArrayBuffer(100), ArrayBuffer(-100), ArrayBuffer(0), ArrayBuff
                                                  //| er(0), ArrayBuffer(111), ArrayBuffer(91), ArrayBuffer(1010), ArrayBuffer(10)
                                                  //| , ArrayBuffer(-89), ArrayBuffer(-109), ArrayBuffer(-990), ArrayBuffer(-9), A
                                                  //| rrayBuffer(110), ArrayBuffer(90), ArrayBuffer(1000), ArrayBuffer(10), ArrayB
                                                  //| uffer(10), ArrayBuffer(-10), ArrayBuffer(0), ArrayBuffer(0), ArrayBuffer(111
                                                  //| ), ArrayBuffer(109), Arr
                                                  //| Output exceeds cutoff limit.
}