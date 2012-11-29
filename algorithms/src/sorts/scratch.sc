package sorts

import sorts._

object scratch {
  val v1 = Vector(1,2,3,4)                        //> v1  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4)
  val v2 = Vector(8,3,4,6,2,5,7,9)                //> v2  : scala.collection.immutable.Vector[Int] = Vector(8, 3, 4, 6, 2, 5, 7, 9
                                                  //| )
  val p1 = (1,2)                                  //> p1  : (Int, Int) = (1,2)
  
  v1.tail                                         //> res0: scala.collection.immutable.Vector[Int] = Vector(2, 3, 4)
  
  val h = new Heap(Vector(8,3,4,6,2,5,7,9))       //> h  : sorts.Heap = 9 8 6 3
	//h.fixFrom(Vector(8,3,4,6))
	
	v1 drop 1+2                               //> res1: scala.collection.immutable.Vector[Int] = Vector(4)
}