object polynomials {
  class Poly(val terms: Map[Int, Double]) {
  	def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
  	def adjust(term: (Int, Double)): (Int, Double) = term match{
  		case (exp, coeff) => terms get exp match {
  			case Some(co) => (exp, coeff+co)
  			case None => term
  		}
  	}
  	
  	override def toString =
  		(for((exp, coeff) <- terms.toList.sorted.reverse) yield coeff+"x^"+exp) mkString " + "
  		
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(505); 
  
  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2));System.out.println("""p1  : polynomials.Poly = """ + $show(p1 ));$skip(45); 
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0));System.out.println("""p2  : polynomials.Poly = """ + $show(p2 ));$skip(13); val res$0 = 
  
  p1 + p2;System.out.println("""res0: polynomials.Poly = """ + $show(res$0))}
}