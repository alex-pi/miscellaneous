package week7

object primes {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(143); 
  // Thanks to lazy evaluation we can build infite definitios.
  def from(n: Int): Stream[Int] = n #:: from(n+1);System.out.println("""from: (n: Int)Stream[Int]""");$skip(29); 
  
  val naturals = from(10);System.out.println("""naturals  : Stream[Int] = """ + $show(naturals ));$skip(36); 
  val multof4 = from(0) map (_ * 4);System.out.println("""multof4  : scala.collection.immutable.Stream[Int] = """ + $show(multof4 ));$skip(26); val res$0 = 
  multof4.take(41).toList;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(96); 
  def sieve(s: Stream[Int]): Stream[Int] =
   s.head #:: sieve(s.tail filter (_ % s.head != 0));System.out.println("""sieve: (s: Stream[Int])Stream[Int]""");$skip(85); val res$1 = 
                                                  
  sieve(from(2)).take(100).toList;System.out.println("""res1: List[Int] = """ + $show(res$1))}
}