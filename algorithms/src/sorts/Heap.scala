package sorts

import math.Ordering.Implicits._

class Heap[T: Ordering](vs: Vector[T]) {
  val heap = build()
  
  private def build():Vector[T] = 
    ((0 until vs.length) foldLeft Vector.empty[T]) ( (accu, idx) =>
      	fixUp(accu :+ vs(idx), idx) )
  
  @annotation.tailrec      	
  private def fixUp(h:Vector[T], idx: Int): Vector[T] = {
      val parentIdx = parent(idx)
      if(parentIdx < 0 || h(idx) <= h(parentIdx)) h
      else fixUp(h.updated(parentIdx, h(idx)).updated(idx, h(parentIdx)), parentIdx)
  }
  
  def parent(idx: Int) = (idx-1) >> 1
    
  override def toString = heap mkString " "
}
