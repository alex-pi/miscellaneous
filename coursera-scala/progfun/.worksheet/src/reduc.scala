object reduc {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(49); 
  val l = 5::4::3::7::2::1::8::Nil;System.out.println("""l  : List[Int] = """ + $show(l ));$skip(22); 
  val l2 = -4::9::Nil;System.out.println("""l2  : List[Int] = """ + $show(l2 ));$skip(37); val res$0 = 
  
  (l) reduceLeft ((x,y) => x * y);System.out.println("""res0: Int = """ + $show(res$0));$skip(32); val res$1 = 
  l reduceLeft ((x,y) => x + y);System.out.println("""res1: Int = """ + $show(res$1));$skip(60); val res$2 = 
  
  // Can be expressed like
  (0 :: l) reduceLeft (_ + _);System.out.println("""res2: Int = """ + $show(res$2));$skip(113); val res$3 = 
  
  // fold is a more general operation, it gives an accumulator (sometimes called seed)
  l.foldLeft(0)(_ + _);System.out.println("""res3: Int = """ + $show(res$3));$skip(24); val res$4 = 
  (l foldLeft 0)(_ + _);System.out.println("""res4: Int = """ + $show(res$4));$skip(84); 
  
  def concat[T](xs: List[T], ys: List[T]): List[T] =
  	xs.foldRight(ys)(_ :: _);System.out.println("""concat: [T](xs: List[T], ys: List[T])List[T]""");$skip(20); val res$5 = 
  	
  concat(l, l2);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(97); 
  
  def mapFun[T, U](xs: List[T], p: T => U): List[U] =>
  	(xs foldRight List[U]())(p(_) :: _);System.out.println("""mapFun: [T, U](xs: List[T], p: T => U)List[U] => <error>""")}
}