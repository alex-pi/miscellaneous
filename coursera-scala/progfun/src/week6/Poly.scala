package week6

class Poly(val terms: Map[Int, Double]) {
  	def + (other: Poly) = new Poly(terms ++ other.terms)
}