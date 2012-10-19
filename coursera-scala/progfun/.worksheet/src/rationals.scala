import math.abs

object rationals {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  var x = new Rational(1,3);System.out.println("""x  : Rational = """ + $show(x ));$skip(28); 
  var y = new Rational(5,7);System.out.println("""y  : Rational = """ + $show(y ));$skip(28); 
  var z = new Rational(3,2);System.out.println("""z  : Rational = """ + $show(z ));$skip(26); 
  var a = new Rational(2);System.out.println("""a  : Rational = """ + $show(a ));$skip(11); val res$0 = 
  
  x + y;System.out.println("""res0: Rational = """ + $show(res$0));$skip(5); val res$1 = 
  -y;System.out.println("""res1: Rational = """ + $show(res$1));$skip(12); val res$2 = 
  x - y - z;System.out.println("""res2: Rational = """ + $show(res$2));$skip(13); val res$3 = 
  
  x max y;System.out.println("""res3: Rational = """ + $show(res$3))}
}

class Rational(x: Int, y: Int){
	require(y != 0, "Denominator must be nonzero")
	
	def this(x: Int) = this(x, 1)
	
	private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
	private val g = gcd(abs(x),abs(y))
	def numer = x / g
	def denom = y / g
	
	def < (that: Rational) = numer * that.denom < that.numer * denom
	
	def max(that: Rational) = if(this < that) that else this
	
	def + (that: Rational) =
		new Rational(
			numer * that.denom + denom * that.numer,
			denom * that.denom
		)
					
	def - (that: Rational) = this + -that

	def unary_- : Rational = new Rational(-numer, denom)
		
	//override def toString = numer/gcd(x,y) + "/" + denom/gcd(x,y)
	
	override def toString = numer + "/" + denom
}