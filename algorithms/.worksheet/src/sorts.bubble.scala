package sorts

object bubble {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(202); 
  
  def phase(xs: List[Int]): List[Int] = xs match {
  	case y :: Nil => List(y)
  	case y :: ys => if(y > ys.head) ys.head :: phase(y :: ys.tail) else y :: phase(ys)
  };System.out.println("""phase: (xs: List[Int])List[Int]""");$skip(194); 
  
  def sort(xs: List[Int]): List[Int] = {
  	def inner(ys: List[Int], phased: List[Int]): List[Int] =
		  	if(ys.isEmpty) phased
  			else inner(ys.tail, phase(phased))
		
		inner(xs, xs)
  };System.out.println("""sort: (xs: List[Int])List[Int]""");$skip(32); val res$0 = 
  
  sort(List(15,13,2,11,6,5));System.out.println("""res0: List[Int] = """ + $show(res$0))}
}