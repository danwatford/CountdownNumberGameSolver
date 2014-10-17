package com.foomoo.countdown

object worksheet {

  val rg = ResultGroup(6, 5, 3, 2)                //> rg  : com.foomoo.countdown.ResultGroup = RG(6,5,3,2)
  val appliedOps = rg.applyOps(Seq(Division(), Plus(), Minus(), Product()))
                                                  //> appliedOps  : Set[com.foomoo.countdown.ResultGroup] = Set(RG(1,6,5), RG(18,5
                                                  //| ,2), RG(3,6,3), RG(9,5,2), RG(4,5,3), RG(1,3,2), RG(2,5,2), RG(6,6,5), RG(10
                                                  //| ,6,3), RG(3,5,2), RG(15,6,2), RG(12,5,3), RG(2,6,2), RG(3,5,3), RG(11,3,2), 
                                                  //| RG(5,6,5), RG(30,3,2), RG(7,6,3), RG(8,6,2), RG(8,5,3))
  appliedOps.size                                 //> res0: Int = 20

  val rgi = new ResultGroupIterator(rg)           //> rgi  : com.foomoo.countdown.ResultGroupIterator = non-empty iterator
  val allResSet = rgi.toSet                       //> allResSet  : scala.collection.immutable.Set[com.foomoo.countdown.ResultGroup
                                                  //| ] = Set(RG(1,6,5), RG(3,10), RG(18,5,2), RG(3,6,3), RG(9,5,2), RG(150), RG(6
                                                  //| 6), RG(17), RG(1), RG(1,1), RG(7,9), RG(54), RG(47), RG(3,15), RG(4,3), RG(3
                                                  //| 5), RG(7,18), RG(27,2), RG(12,5), RG(33,2), RG(18), RG(8,12), RG(4,5,3), RG(
                                                  //| 8), RG(9,3), RG(19), RG(3,3), RG(78), RG(41), RG(2,3), RG(6,5,3,2), RG(11,6)
                                                  //| , RG(45), RG(16), RG(20,5), RG(2,2), RG(13), RG(6,5), RG(39), RG(5,5), RG(1,
                                                  //| 3,2), RG(30,5), RG(2,12), RG(9), RG(30), RG(80), RG(63), RG(7), RG(18,5), RG
                                                  //| (15), RG(45,2), RG(3), RG(51), RG(48), RG(17,3), RG(7,2), RG(32,3), RG(4,2),
                                                  //|  RG(9,5), RG(2,5,2), RG(16,6), RG(46), RG(102), RG(15,5), RG(13,3), RG(126),
                                                  //|  RG(120), RG(8,4), RG(100), RG(24), RG(6,6,5), RG(12,15), RG(16,5), RG(28), 
                                                  //| RG(10,2), RG(31), RG(30,1), RG(29), RG(1,6), RG(7,6), RG(22), RG(10,6,3), RG
                                                  //| (16,3), RG(3,5,2), RG(40,3), RG(1,5), RG(11,5), RG(20,3), RG(180), RG(9,2), 
                                                  //| RG(7,5), RG(48,2), RG(8,
                                                  //| Output exceeds cutoff limit.

  allResSet.map(_.getMatching(15)).flatten.map(NumberResultFormatter.format(_)).mkString("\n")
                                                  //> res1: String = ((6 - 3) * 5)
                                                  //| (5 * 3)
                                                  //| ((6 * 2) + 3)
                                                  //| (((6 * 3) + 2) - 5)

  val solution = SolutionFinder.findSolution(231, 100, 75, 10, 5, 3, 2)
                                                  //> solution  : Option[com.foomoo.countdown.NumberResult] = Some(NumberResult(23
                                                  //| 1,NumberResult(77,NumberResult(75,null,null,null),NumberResult(2,null,null,n
                                                  //| ull),Plus()),NumberResult(3,null,null,null),Product()))
  solution.map(NumberResultFormatter.format(_))   //> res2: Option[String] = Some(((75 + 2) * 3))
}