package week5

object reduc {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 
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
  	
  concat(l, l2);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(96); 
  
  def mapFun[T, U](xs: List[T], p: T => U): List[U] =
  	(xs foldRight List[U]())(p(_) :: _);System.out.println("""mapFun: [T, U](xs: List[T], p: T => U)List[U]""");$skip(120); 
  	
  def mapFun2[T, U](xs: List[T], p: T => U): List[U] =
  	(xs foldRight List[U]())((y:T, ys:List[U]) => p(y) :: ys);System.out.println("""mapFun2: [T, U](xs: List[T], p: T => U)List[U]""");$skip(166); 
                                                  
  def mapFun3[T, U](xs: List[T], p: T => U): List[U] =
  	(xs foldLeft List[U]())((ys:List[U], y:T) => p(y) :: ys);System.out.println("""mapFun3: [T, U](xs: List[T], p: T => U)List[U]""");$skip(169); 
                                                  
  def mapFun4[T, U](xs: List[T], p: T => U): List[U] =
  	(xs foldLeft List[U]()) ( (ys:List[U], y:T) => ys :+ p(y) );System.out.println("""mapFun4: [T, U](xs: List[T], p: T => U)List[U]""");$skip(145); 
                                                  
  def mapFun5[T, U](xs: List[T], p: T => U): List[U] =
  	(xs foldLeft List[U]())(_ :+ p(_) );System.out.println("""mapFun5: [T, U](xs: List[T], p: T => U)List[U]""");$skip(87); 
  	
  def lengthFun[T](xs: List[T]): Int =
  	(xs foldLeft 0)((n: Int, x: T) => n + 1);System.out.println("""lengthFun: [T](xs: List[T])Int""");$skip(89); 
  	
  def lengthFun2[T](xs: List[T]): Int =
  	(xs foldRight 0)((x: T, n: Int) => n + 1);System.out.println("""lengthFun2: [T](xs: List[T])Int""");$skip(33); val res$6 = 
  
  mapFun(l, (x:Int) => x + 1);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(31); val res$7 = 
  mapFun2(l, (x:Int) => x + 1);System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(31); val res$8 = 
  mapFun3(l, (x:Int) => x + 1);System.out.println("""res8: List[Int] = """ + $show(res$8));$skip(31); val res$9 = 
  mapFun4(l, (x:Int) => x + 1);System.out.println("""res9: List[Int] = """ + $show(res$9));$skip(31); val res$10 = 
  mapFun5(l, (x:Int) => x + 1);System.out.println("""res10: List[Int] = """ + $show(res$10));$skip(18); val res$11 = 
  
  lengthFun(l);System.out.println("""res11: Int = """ + $show(res$11));$skip(16); val res$12 = 
  lengthFun2(l);System.out.println("""res12: Int = """ + $show(res$12))}
}