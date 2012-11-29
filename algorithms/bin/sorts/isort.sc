package sorts

object isort {
  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  	case Nil => x :: Nil
  	case y :: ys => if(y >= x) x :: xs else y :: insert(x, ys)
  }                                               //> insert: (x: Int, xs: List[Int])List[Int]

  def isort(xs: List[Int]): List[Int] = xs match {
  	case Nil => List()
  	case y :: ys => insert(y, isort(ys))
  }                                               //> isort: (xs: List[Int])List[Int]
  
  isort(5::4::3::7::2::1::8::Nil)                 //> res0: List[Int] = List(1, 2, 3, 4, 5, 7, 8)
  3 :: 4 :: Nil                                   //> res1: List[Int] = List(3, 4)
}