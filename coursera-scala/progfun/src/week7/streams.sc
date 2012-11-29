package week7

object streams {
  
  (1 to 1000).toStream                            //> res0: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  val s1 = Stream(1,2,3,4)                        //> s1  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  s1.tail                                         //> res1: scala.collection.immutable.Stream[Int] = Stream(2, ?)
  
  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    print(lo+" ")
  	if(lo > hi) Stream.empty
  	else Stream.cons(lo, streamRange(lo+1, hi))
  }                                               //> streamRange: (lo: Int, hi: Int)Stream[Int]
  
  // using toList we force to evaluate the stream completely
  streamRange(1, 10).toList                       //> 1 2 3 4 5 6 7 8 9 10 11 res2: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                                                  //| )
  // when we evaluate this, it will stop when it finds the number 3
  val s2 = streamRange(1, 10).take(3)             //> 1 s2  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  s2.toList                                       //> 2 3 res3: List[Int] = List(1, 2, 3)
  // from this point all the stream elements are evaluated
  s2.toList                                       //> res4: List[Int] = List(1, 2, 3)
}