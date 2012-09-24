object FirstWS {
  val x = 1                                       //> x  : Int = 1
  def increase(i: Int) = i + 1                    //> increase: (i: Int)Int
  increase(x)                                     //> res0: Int = 2
  
  val xs = List(1,3)                              //> xs  : List[Int] = List(1, 3)
  xs.head                                         //> res1: Int = 1
  xs.tail                                         //> res2: List[Int] = List(3)
  xs.tail.head                                    //> res3: Int = 3
}