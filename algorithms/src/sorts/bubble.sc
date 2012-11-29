package sorts

object bubble {
  
  def phase(xs: List[Int]): List[Int] = xs match {
  	case y :: Nil => List(y)
  	case y :: ys => if(y > ys.head) ys.head :: phase(y :: ys.tail) else y :: phase(ys)
  }                                               //> phase: (xs: List[Int])List[Int]
  
  def sort(xs: List[Int]): List[Int] = {
  	def inner(ys: List[Int], phased: List[Int]): List[Int] =
		  	if(ys.isEmpty) phased
  			else inner(ys.tail, phase(phased))
		
		inner(xs, xs)
  }                                               //> sort: (xs: List[Int])List[Int]
  
  sort(List(15,13,2,11,6,5))                      //> res0: List[Int] = List(2, 5, 6, 11, 13, 15)
}