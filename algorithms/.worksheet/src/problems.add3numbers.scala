package problems

import sorts.mergesort._

object add3numbers {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  val firstu = List(3,6,-9,-12,15);System.out.println("""firstu  : List[Int] = """ + $show(firstu ));$skip(35); 
  val secondu = List(2,-5,8,13,17);System.out.println("""secondu  : List[Int] = """ + $show(secondu ));$skip(40); 
  val thirdu = List(1,-3,5,-10,-15,-19);System.out.println("""thirdu  : List[Int] = """ + $show(thirdu ));$skip(531); 
  
  def findSolutions(first: List[Int], second: List[Int], third: List[Int], sum: Int) = {
  	val ss = msort(second)
  	val combs = (for (f <- msort(first); s <- ss) yield (f, s))
  			.groupBy {case (f, s) => f + s - sum} withDefaultValue List()
  	
  	@annotation.tailrec
  	def find(xs: List[Int], accu: Stream[(Int,Int,Int)]): Stream[(Int,Int,Int)] =
  		if(xs.isEmpty) accu
  		else {
  			val sols = combs(-xs.head) map{case (f, s) => (f,s,xs.head)}
  			find(xs.tail, accu ++ sols)
  		}
  		
    find(third, Stream())
  };System.out.println("""findSolutions: (first: List[Int], second: List[Int], third: List[Int], sum: Int)Stream[(Int, Int, Int)]""");$skip(62); val res$0 = 
  
  findSolutions(firstu, secondu, thirdu, 0).take(3).toList;System.out.println("""res0: List[(Int, Int, Int)] = """ + $show(res$0));$skip(54); val res$1 = 
  
  findSolutions(firstu, secondu, thirdu, 2).toList;System.out.println("""res1: List[(Int, Int, Int)] = """ + $show(res$1))}
}