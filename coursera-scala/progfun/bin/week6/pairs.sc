object pairs {
  val n = 7                                       //> n  : Int = 7
  
  def isPrime(n: Int): Boolean =
  	(2 until n).forall(x => n % x != 0)       //> isPrime: (n: Int)Boolean
  	  
  (1 until n) flatMap (i =>
  	(1 until i)	map (j => (i,j))) filter {
  		case (x,y) => isPrime(x+y)}       //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  for {
  	i <- 1 until n
  	j <- 1 until i
  	if isPrime(i+j)
  } yield (i, j)                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  def scalarProduct1(xs: Vector[Double], ys: Vector[Double]): Double =
  	//(xs zip ys).map(xy => xy._1 * xy._2).sum
  	(xs zip ys).map{case(x,y) => x * y}.sum   //> scalarProduct1: (xs: Vector[Double], ys: Vector[Double])Double
  
  def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
  	(for ((x,y) <- xs zip ys) yield x*y).sum  //> scalarProduct2: (xs: Vector[Double], ys: Vector[Double])Double
 
  def scalarProduct3(xs: Vector[Double], ys: Vector[Double]): Double =
  	(for {
  		x <- xs
  		y <- ys
  	} yield x*y).sum                          //> scalarProduct3: (xs: Vector[Double], ys: Vector[Double])Double
  
  scalarProduct1(Vector(1,2,3), Vector(-1,-2,-3,5))
                                                  //> res2: Double = -14.0
  
  scalarProduct2(Vector(1,2,3), Vector(-1,-2,-3,5))
                                                  //> res3: Double = -14.0
                                                  
  scalarProduct3(Vector(1,2,3), Vector(-1,-2,-3,5))
                                                  //> res4: Double = -6.0
}