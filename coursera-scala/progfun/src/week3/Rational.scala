package week3

import math.abs

class Rational(x: Int, y: Int) {
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