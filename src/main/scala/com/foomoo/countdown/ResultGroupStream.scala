package com.foomoo.countdown

class ResultGroupIterator (root: ResultGroup) extends Iterator[ResultGroup] {
	var l: List[ResultGroup] = List(root)
  
	def hasNext: Boolean = ! l.isEmpty
	
	def next: ResultGroup = {
	  val result = l.head
	  l = l.tail ++ result.applyOps(Seq(Plus(), Minus(), Product(), Division()))
	  result
	}
}	