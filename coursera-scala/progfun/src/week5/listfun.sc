object listfun {
  val nums = 5::4::3::7::2::(-1)::8::Nil          //> nums  : List[Int] = List(5, 4, 3, 7, 2, -1, 8)
  val l2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)    //> l2  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val fruits = "grape"::"pineapple"::"pear"::"orange"::Nil
                                                  //> fruits  : List[java.lang.String] = List(grape, pineapple, pear, orange)
                                                  
  nums filter (x => x > 0)                        //> res0: List[Int] = List(5, 4, 3, 7, 2, 8)
  nums filterNot (x => x > 0)                     //> res1: List[Int] = List(-1)
  nums partition (x => x > 0)                     //> res2: (List[Int], List[Int]) = (List(5, 4, 3, 7, 2, 8),List(-1))
  nums takeWhile (x => x > 2)                     //> res3: List[Int] = List(5, 4, 3, 7)
  l2 takeWhile (x => x > 3)                       //> res4: List[Int] = List()
  (1 to 10).toList                                //> res5: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  nums dropWhile (x => x > 2)                     //> res6: List[Int] = List(2, -1, 8)
  nums span (x => x > 2)                          //> res7: (List[Int], List[Int]) = (List(5, 4, 3, 7),List(2, -1, 8))
  
  def pack[T](xs: List[T]): List[List[T]] = xs match {
  	case Nil => Nil
  	case y :: ys =>
  		val (taken, dropped) = xs span (x => x == y)
  		taken :: pack(dropped)
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  pack(List("a","a","b","c","c","c","d"))         //> res8: List[List[java.lang.String]] = List(List(a, a), List(b), List(c, c, c)
                                                  //| , List(d))
  def encode[T](xs: List[T]): List[(T,Int)] =
  	pack(xs) map (ys => (ys.head, ys.length)) //> encode: [T](xs: List[T])List[(T, Int)]
  
  encode(List("a","a","b","c","c","c","d"))       //> res9: List[(java.lang.String, Int)] = List((a,2), (b,1), (c,3), (d,1))
}