package sorts

import scala.math.Ordering.Implicits._

object heap_stackover {

def insert[T : Ordering](heap: Vector[T], newItem: T) = {
  @annotation.tailrec
  def siftUp(h: Vector[T], idx: Int):Vector[T] = {
    val parentIdx = (idx - 1) >> 1
    if(parentIdx < 0 || h(parentIdx) > h(idx)) h
    else siftUp(h.updated(parentIdx, h(idx)).updated(idx, h(parentIdx)), parentIdx)
  }

  siftUp(heap :+ newItem, heap.length)
}                                                 //> insert: [T](heap: Vector[T], newItem: T)(implicit evidence$1: Ordering[T])Ve
                                                  //| ctor[T]
def heapify[T: Ordering](vs: Vector[T]) = vs.foldLeft(Vector.empty[T])(insert)
                                                  //> heapify: [T](vs: Vector[T])(implicit evidence$2: Ordering[T])scala.collectio
                                                  //| n.immutable.Vector[T]

heapify(Vector(8, 3, 4, 6, 2, 5, 7, 9)) == Vector(9, 8, 7, 6, 2, 4, 5, 3)
                                                  //> res0: Boolean = true

(6-1) >> 1                                        //> res1: Int = 2

}