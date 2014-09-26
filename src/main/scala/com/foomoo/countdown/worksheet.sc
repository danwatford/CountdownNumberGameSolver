package com.foomoo.countdown

object worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val rg = ResultGroup(1, 10, 100)                //> rg  : com.foomoo.countdown.ResultGroup = ArrayBuffer(1, 10, 100)
  
  rg.applyOps(Seq(Division(), Plus(), Minus(), Product()))
                                                  //> res0: scala.collection.immutable.Set[com.foomoo.countdown.ResultGroup] = Set
                                                  //| (ArrayBuffer(1000, 1), ArrayBuffer(1000, 1), ArrayBuffer(-9, 100), ArrayBuff
                                                  //| er(-99, 10), ArrayBuffer(110, 1), ArrayBuffer(110, 1), ArrayBuffer(100, 10),
                                                  //|  ArrayBuffer(100, 10), ArrayBuffer(10, 100), ArrayBuffer(10, 100), ArrayBuff
                                                  //| er(100, 10), ArrayBuffer(10, 100), ArrayBuffer(10, 1), ArrayBuffer(101, 10),
                                                  //|  ArrayBuffer(101, 10), ArrayBuffer(99, 10), ArrayBuffer(90, 1), ArrayBuffer(
                                                  //| 11, 100), ArrayBuffer(11, 100), ArrayBuffer(9, 100), ArrayBuffer(-90, 1))
  
  //val rgi = new ResultGroupIterator(rg)
 
  //rgi.take(50).toList
}