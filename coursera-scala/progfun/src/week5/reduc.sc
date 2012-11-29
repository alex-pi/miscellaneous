package week5

object reduc {
  val l = 5::4::3::7::2::1::8::Nil                //> l  : List[Int] = List(5, 4, 3, 7, 2, 1, 8)
  val l2 = -4::9::Nil                             //> l2  : List[Int] = List(-4, 9)
  
  (l) reduceLeft ((x,y) => x * y)                 //> res0: Int = 6720
  l reduceLeft ((x,y) => x + y)                   //> res1: Int = 30
  
  // Can be expressed like
  (0 :: l) reduceLeft (_ + _)                     //> res2: Int = 30
  
  // fold is a more general operation, it gives an accumulator (sometimes called seed)
  l.foldLeft(0)(_ + _)                            //> res3: Int = 30
  (l foldLeft 0)(_ + _)                           //> res4: Int = 30
  
  def concat[T](xs: List[T], ys: List[T]): List[T] =
  	xs.foldRight(ys)(_ :: _)                  //> concat: [T](xs: List[T], ys: List[T])List[T]
  	
  concat(l, l2)                                   //> res5: List[Int] = List(5, 4, 3, 7, 2, 1, 8, -4, 9)
  
  def mapFun[T, U](xs: List[T], p: T => U): List[U] =
  	(xs foldRight List[U]())(p(_) :: _)       //> mapFun: [T, U](xs: List[T], p: T => U)List[U]
  	
  def mapFun2[T, U](xs: List[T], p: T => U): List[U] =
  	(xs foldRight List[U]())((y:T, ys:List[U]) => p(y) :: ys)
                                                  //> mapFun2: [T, U](xs: List[T], p: T => U)List[U]
                                                  
  def mapFun3[T, U](xs: List[T], p: T => U): List[U] =
  	(xs foldLeft List[U]())((ys:List[U], y:T) => p(y) :: ys)
                                                  //> mapFun3: [T, U](xs: List[T], p: T => U)List[U]
                                                  
  def mapFun4[T, U](xs: List[T], p: T => U): List[U] =
  	(xs foldLeft List[U]()) ( (ys:List[U], y:T) => ys :+ p(y) )
                                                  //> mapFun4: [T, U](xs: List[T], p: T => U)List[U]
                                                  
  def mapFun5[T, U](xs: List[T], p: T => U): List[U] =
  	(xs foldLeft List[U]())(_ :+ p(_) )       //> mapFun5: [T, U](xs: List[T], p: T => U)List[U]
  	
  def lengthFun[T](xs: List[T]): Int =
  	(xs foldLeft 0)((n: Int, x: T) => n + 1)  //> lengthFun: [T](xs: List[T])Int
  	
  def lengthFun2[T](xs: List[T]): Int =
  	(xs foldRight 0)((x: T, n: Int) => n + 1) //> lengthFun2: [T](xs: List[T])Int
  
  mapFun(l, (x:Int) => x + 1)                     //> res6: List[Int] = List(6, 5, 4, 8, 3, 2, 9)
  mapFun2(l, (x:Int) => x + 1)                    //> res7: List[Int] = List(6, 5, 4, 8, 3, 2, 9)
  mapFun3(l, (x:Int) => x + 1)                    //> res8: List[Int] = List(9, 2, 3, 8, 4, 5, 6)
  mapFun4(l, (x:Int) => x + 1)                    //> res9: List[Int] = List(6, 5, 4, 8, 3, 2, 9)
  mapFun5(l, (x:Int) => x + 1)                    //> res10: List[Int] = List(6, 5, 4, 8, 3, 2, 9)
  
  lengthFun(l)                                    //> res11: Int = 7
  lengthFun2(l)                                   //> res12: Int = 7
}