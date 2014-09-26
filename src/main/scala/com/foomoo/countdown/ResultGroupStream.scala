package com.foomoo.countdown

import java.awt.Queue
import scala.collection.mutable.Queue

class ResultGroupIterator (root: ResultGroup) extends Iterator[ResultGroup] {
	private val l: Queue[ResultGroup] = Queue(root)
  
	def hasNext: Boolean = ! l.isEmpty
	
	def next: ResultGroup = {
	  val result = l.dequeue
	  l ++= result.applyOps(Seq(Plus(), Minus(), Product(), Division()))
	  result
	}
}	