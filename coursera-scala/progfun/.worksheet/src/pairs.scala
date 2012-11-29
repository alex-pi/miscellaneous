object pairs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(26); 
  val n = 7;System.out.println("""n  : Int = """ + $show(n ));$skip(75); 
  
  def isPrime(n: Int): Boolean =
  	(2 until n).forall(x => n % x != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(108); val res$0 = 
  	  
  (1 until n) flatMap (i =>
  	(1 until i)	map (j => (i,j))) filter {
  		case (x,y) => isPrime(x+y)};System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(80); val res$1 = 
  for {
  	i <- 1 until n
  	j <- 1 until i
  	if isPrime(i+j)
  } yield (i, j);System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(160); 
  def scalarProduct1(xs: Vector[Double], ys: Vector[Double]): Double =
  	//(xs zip ys).map(xy => xy._1 * xy._2).sum
  	(xs zip ys).map{case(x,y) => x * y}.sum;System.out.println("""scalarProduct1: (xs: Vector[Double], ys: Vector[Double])Double""");$skip(118); 
  
  def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
  	(for ((x,y) <- xs zip ys) yield x*y).sum;System.out.println("""scalarProduct2: (xs: Vector[Double], ys: Vector[Double])Double""");$skip(127); 
 
  def scalarProduct3(xs: Vector[Double], ys: Vector[Double]): Double =
  	(for {
  		x <- xs
  		y <- ys
  	} yield x*y).sum;System.out.println("""scalarProduct3: (xs: Vector[Double], ys: Vector[Double])Double""");$skip(55); val res$2 = 
  
  scalarProduct1(Vector(1,2,3), Vector(-1,-2,-3,5));System.out.println("""res2: Double = """ + $show(res$2));$skip(55); val res$3 = 
  
  scalarProduct2(Vector(1,2,3), Vector(-1,-2,-3,5));System.out.println("""res3: Double = """ + $show(res$3));$skip(103); val res$4 = 
                                                  
  scalarProduct3(Vector(1,2,3), Vector(-1,-2,-3,5));System.out.println("""res4: Double = """ + $show(res$4))}
}