package week6

object polynomials2 {
  class Poly(terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)
  	val terms = terms0 withDefaultValue 0.0
  	def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
  	def adjust(term: (Int, Double)): (Int, Double) = term match {
  		case (exp, coeff) => (exp, coeff + terms(exp))
  	}
  	
  	def plus(other: Poly) =
  		new Poly((other.terms foldLeft terms)(addTerm))
  		
    def addTerm(accu: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
    	val (exp, coeff) = term
    	accu + (exp -> (coeff + accu(exp)))
  	}
  	
  	override def toString =
  		(for((exp, coeff) <- terms.toList.sorted.reverse) yield coeff+"x^"+exp) mkString " + "
  		
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(802); 
  
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2);System.out.println("""p1  : week6.polynomials2.Poly = """ + $show(p1 ));$skip(40); 
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0);System.out.println("""p2  : week6.polynomials2.Poly = """ + $show(p2 ));$skip(13); val res$0 = 
  
  p1 + p2;System.out.println("""res0: week6.polynomials2.Poly = """ + $show(res$0));$skip(16); val res$1 = 
  
  p1 plus p2;System.out.println("""res1: week6.polynomials2.Poly = """ + $show(res$1))}
}