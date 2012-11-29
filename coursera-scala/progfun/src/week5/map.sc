object map {
  def squareList(xs: List[Int]): List[Int] = xs match {
  	case Nil => xs
  	case x :: xt => x * x :: squareList(xt)
  }                                               //> squareList: (xs: List[Int])List[Int]
  
  def squareList2(xs: List[Int]): List[Int] =
  	xs map (x => x * x)                       //> squareList2: (xs: List[Int])List[Int]
  
  squareList(1::3::7::Nil)                        //> res0: List[Int] = List(1, 9, 49)
  squareList2(1::3::7::Nil)                       //> res1: List[Int] = List(1, 9, 49)
}