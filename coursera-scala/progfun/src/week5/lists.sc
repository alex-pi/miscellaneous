object lists {
  def init[T](xs: List[T]): List[T] = xs match {
  	case Nil => throw new Error("Init of empty list")
  	case x :: Nil => List()
  	case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]
  
  def last[T](xs: List[T]): T = xs match {
  	case Nil => throw new Error("Last of empty list")
  	case x :: Nil => x
  	case y :: ys => last(ys)
  }                                               //> last: [T](xs: List[T])T
  
  // Is not lineal :( <-- sad face
  def reverse[T](xs: List[T]): List[T] = xs match {
  	case Nil => List()
  	case y :: ys => reverse(ys) ++ List(y)
  }                                               //> reverse: [T](xs: List[T])List[T]
  
  def removeAt[T](xs: List[T], n: Int): List[T] = xs match {
  	case Nil => xs
  	case y :: ys => if(n==0) ys else y :: removeAt(ys, n-1)
  }                                               //> removeAt: [T](xs: List[T], n: Int)List[T]
  
  def removeAt2[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n+1)
                                                  //> removeAt2: [T](n: Int, xs: List[T])List[T]
  
/*  def flatten(xs: List[Any]): List[Any] = xs match {
  	case List() => xs
  	case y :: ys => y match {
  		case z :: zs => flatten(z :: zs) ::: flatten(ys)
  		case y => y :: flatten(ys)
  	}
  }
  */
  
	 def flatten(xs: List[Any]): List[Any] = xs match {
	    case Nil => xs
	    case (y:List[Any]) :: ys => flatten(y) ::: flatten(ys)
	    case y :: ys => y :: flatten(ys)
	 }                                        //> flatten: (xs: List[Any])List[Any]
  
  init(5::4::3::7::2::1::8::Nil)                  //> res0: List[Int] = List(5, 4, 3, 7, 2, 1)
  last(5::4::3::7::2::1::8::Nil)                  //> res1: Int = 8
  reverse(5::4::3::7::2::1::8::Nil)               //> res2: List[Int] = List(8, 1, 2, 7, 3, 4, 5)
  removeAt(5::4::3::7::2::1::8::Nil,10)           //> res3: List[Int] = List(5, 4, 3, 7, 2, 1, 8)
  removeAt2(1, 5::4::3::7::2::1::8::Nil)          //> res4: List[Int] = List(5, 3, 7, 2, 1, 8)
  flatten(List(1,2,List('a','b','c'),3, List(4,5, List('y','z'))))
                                                  //> res5: List[Any] = List(1, 2, a, b, c, 3, 4, 5, y, z)
                                                  
                                                    
}