package mathalgs

object gcd {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(277); 
	def gcd(a : Int, b : Int) : Int = {
	  def gcd_(a: Int, b : Int) : Int = {
	    (a,b) match {
	      case (_,0) => a
	      case (0,_) => b
	      case (_,_) => gcd_(math.min(a,b), math.abs(a - b))
	    }
	  }
	  gcd_(math.abs(a),math.abs(b))
	};System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(13); val res$0 = 

	gcd(15,35);System.out.println("""res0: Int = """ + $show(res$0));$skip(67); 
	
	def gcd2(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b);System.out.println("""gcd2: (a: Int, b: Int)Int""");$skip(15); val res$1 = 
	
	gcd2(15,35);System.out.println("""res1: Int = """ + $show(res$1))}
}