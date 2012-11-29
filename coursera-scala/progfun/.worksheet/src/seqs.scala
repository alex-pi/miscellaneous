object seqs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(156); 
  //Vector, List and Range are subtypes of Sequence"
  //We can also use de Seq's operations on String and Array
  
  val xs = Array(1,2,3,44);System.out.println("""xs  : Array[Int] = """ + $show(xs ));$skip(22); val res$0 = 
  xs map (x => x * 2);System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(28); 
  
  val s = "Hello World!";System.out.println("""s  : java.lang.String = """ + $show(s ));$skip(32); val res$1 = 
  s filter (c => c.isUpperCase);System.out.println("""res1: String = """ + $show(res$1));$skip(23); 
  val pairs = xs zip s;System.out.println("""pairs  : Array[(Int, Char)] = """ + $show(pairs ));$skip(34); val res$2 = 
  
  s flatMap (c => '.'::c::Nil);System.out.println("""res2: String = """ + $show(res$2));$skip(162); 
  
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  	//(xs zip ys).map(xy => xy._1 * xy._2).sum
  	(xs zip ys).map{case(x,y) => x * y}.sum;System.out.println("""scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double""");$skip(54); val res$3 = 
  
  scalarProduct(Vector(1,2,3), Vector(-1,-2,-3,5));System.out.println("""res3: Double = """ + $show(res$3));$skip(75); 
  
  def isPrime(n: Int): Boolean =
  	(2 until n).forall(x => n % x != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(17); val res$4 = 
  	
  isPrime(7);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(14); val res$5 = 
  isPrime(40);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(19); val res$6 = 
  
  List() == Nil;System.out.println("""res6: Boolean = """ + $show(res$6))}
}