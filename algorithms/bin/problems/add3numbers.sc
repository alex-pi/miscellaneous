package problems

import sorts.mergesort._

object add3numbers {
  val firstu = List(3,6,-9,-12,15)                //> firstu  : List[Int] = List(3, 6, -9, -12, 15)
  val secondu = List(2,-5,8,13,17)                //> secondu  : List[Int] = List(2, -5, 8, 13, 17)
  val thirdu = List(1,-3,5,-10,-15,-19)           //> thirdu  : List[Int] = List(1, -3, 5, -10, -15, -19)
  
  def findSolutions(first: List[Int], second: List[Int], third: List[Int], sum: Int) = {
  	val ss = msort(second)
  	val combs = (for (f <- msort(first); s <- ss) yield (f, s))
  			.groupBy {case (f, s) => f + s - sum} withDefaultValue List()
  	
  	@annotation.tailrec
  	def find(xs: List[Int], accu: Stream[(Int,Int,Int)]): Stream[(Int,Int,Int)] =
  		if(xs.isEmpty) accu
  		else {
  			val sols = combs(-xs.head) map{case (f, s) => (f,s,xs.head)}
  			find(xs.tail, accu ++ sols)
  		}
  		
    find(third, Stream())
  }                                               //> findSolutions: (first: List[Int], second: List[Int], third: List[Int], sum: 
                                                  //| Int)Stream[(Int, Int, Int)]
  
  findSolutions(firstu, secondu, thirdu, 0).take(3).toList
                                                  //> res0: List[(Int, Int, Int)] = List((-9,8,1), (15,-5,-10), (6,13,-19))
  
  findSolutions(firstu, secondu, thirdu, 2).toList//> res1: List[(Int, Int, Int)] = List((-12,13,1), (6,-5,1), (-12,17,-3), (3,2,-
                                                  //| 3), (15,2,-15))
}