object listfun {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  val nums = 5::4::3::7::2::(-1)::8::Nil;System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(47); 
  val l2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);System.out.println("""l2  : List[Int] = """ + $show(l2 ));$skip(59); 
  val fruits = "grape"::"pineapple"::"pear"::"orange"::Nil;System.out.println("""fruits  : List[java.lang.String] = """ + $show(fruits ));$skip(78); val res$0 = 
                                                  
  nums filter (x => x > 0);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(30); val res$1 = 
  nums filterNot (x => x > 0);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(30); val res$2 = 
  nums partition (x => x > 0);System.out.println("""res2: (List[Int], List[Int]) = """ + $show(res$2));$skip(30); val res$3 = 
  nums takeWhile (x => x > 2);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(28); val res$4 = 
  l2 takeWhile (x => x > 3);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(19); val res$5 = 
  (1 to 10).toList;System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(30); val res$6 = 
  nums dropWhile (x => x > 2);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(25); val res$7 = 
  nums span (x => x > 2);System.out.println("""res7: (List[Int], List[Int]) = """ + $show(res$7));$skip(176); 
  
  def pack[T](xs: List[T]): List[List[T]] = xs match {
  	case Nil => Nil
  	case y :: ys =>
  		val (taken, dropped) = xs span (x => x == y)
  		taken :: pack(dropped)
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(45); val res$8 = 
  
  pack(List("a","a","b","c","c","c","d"));System.out.println("""res8: List[List[java.lang.String]] = """ + $show(res$8));$skip(91); 
  def encode[T](xs: List[T]): List[(T,Int)] =
  	pack(xs) map (ys => (ys.head, ys.length));System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(47); val res$9 = 
  
  encode(List("a","a","b","c","c","c","d"));System.out.println("""res9: List[(java.lang.String, Int)] = """ + $show(res$9))}
}