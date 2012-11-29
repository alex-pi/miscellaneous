package week6

object polynomials {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(89); 
  
  val p1 = Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2));System.out.println("""p1  : <error> = """ + $show(p1 ));$skip(41); 
  val p2 = Poly(Map(0 -> 3.0, 3 -> 7.0));System.out.println("""p2  : <error> = """ + $show(p2 ));$skip(13); val res$0 = 
  
  p1 + p2;System.out.println("""res0: <error> = """ + $show(res$0))}
  
 class Poly(val terms: Map[Int, Double]) {
  	def + (other: Poly) = new Poly(terms ++ other.terms)
 }
}