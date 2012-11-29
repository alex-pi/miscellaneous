object seqs {
  //Vector, List and Range are subtypes of Sequence"
  //We can also use de Seq's operations on String and Array
  
  val xs = Array(1,2,3,44)                        //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello World!"                          //> s  : java.lang.String = Hello World!
  s filter (c => c.isUpperCase)                   //> res1: String = HW
  val pairs = xs zip s                            //> pairs  : Array[(Int, Char)] = Array((1,H), (2,e), (3,l), (44,l))
  
  s flatMap (c => '.'::c::Nil)                    //> res2: String = .H.e.l.l.o. .W.o.r.l.d.!
  
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  	//(xs zip ys).map(xy => xy._1 * xy._2).sum
  	(xs zip ys).map{case(x,y) => x * y}.sum   //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
  
  scalarProduct(Vector(1,2,3), Vector(-1,-2,-3,5))//> res3: Double = -14.0
  
  def isPrime(n: Int): Boolean =
  	(2 until n).forall(x => n % x != 0)       //> isPrime: (n: Int)Boolean
  	
  isPrime(7)                                      //> res4: Boolean = true
  isPrime(40)                                     //> res5: Boolean = false
  
  List() == Nil                                   //> res6: Boolean = true
}