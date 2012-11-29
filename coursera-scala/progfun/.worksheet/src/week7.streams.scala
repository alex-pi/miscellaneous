package week7

object streams {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); val res$0 = 
  
  (1 to 1000).toStream;System.out.println("""res0: scala.collection.immutable.Stream[Int] = """ + $show(res$0));$skip(30); 
  
  val s1 = Stream(1,2,3,4);System.out.println("""s1  : scala.collection.immutable.Stream[Int] = """ + $show(s1 ));$skip(10); val res$1 = 
  s1.tail;System.out.println("""res1: scala.collection.immutable.Stream[Int] = """ + $show(res$1));$skip(153); 
  
  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    print(lo+" ")
  	if(lo > hi) Stream.empty
  	else Stream.cons(lo, streamRange(lo+1, hi))
  };System.out.println("""streamRange: (lo: Int, hi: Int)Stream[Int]""");$skip(92); val res$2 = 
  
  // using toList we force to evaluate the stream completely
  streamRange(1, 10).toList;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(106); 
  // when we evaluate this, it will stop when it finds the number 3
  val s2 = streamRange(1, 10).take(3);System.out.println("""s2  : scala.collection.immutable.Stream[Int] = """ + $show(s2 ));$skip(12); val res$3 = 
  s2.toList;System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(71); val res$4 = 
  // from this point all the stream elements are evaluated
  s2.toList;System.out.println("""res4: List[Int] = """ + $show(res$4))}
}