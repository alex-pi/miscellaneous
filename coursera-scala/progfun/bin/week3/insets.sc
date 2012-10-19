object insets {
	val t1 = new NonEmpty(3, new Empty, new Empty)
                                                  //> t1  : NonEmpty = {.3.}
	val t2 = t1 incl 4                        //> t2  : IntSet = {.3{.4.}}
	
	val ta = new NonEmpty(5, new NonEmpty(3, new Empty, new Empty),
						new NonEmpty(11, new NonEmpty(9, new Empty, new Empty),
														new NonEmpty(12, new Empty, new Empty))
						) //> ta  : NonEmpty = {{.3.}5{{.9.}11{.12.}}}
						
  val tb = new NonEmpty(2, new NonEmpty(1, new Empty, new Empty),
  								new NonEmpty(3, new Empty, new Empty))
                                                  //> tb  : NonEmpty = {{.1.}2{.3.}}
  ta union tb                                     //> res0: IntSet = {{.1.}2{.3{{.5.}9{{.11.}12.}}}}
}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

class Empty extends IntSet {
	def incl(x: Int) = new NonEmpty(x, new Empty, new Empty)
	def contains(x: Int) = false
	def union(other: IntSet) = other
	
	override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	
	def incl(x: Int) = {
		if(x < elem) new NonEmpty(elem, left incl x, right)
		else if(x > elem) new NonEmpty(elem, left, right incl x)
		else this
	}
	
	def contains(x: Int): Boolean = {
		if(x < elem) left contains x
		else if(x > elem) right contains x
		else true
	}
	
	def union(other: IntSet) =
		((left union right) union other) incl elem
	
	override def toString = "{" + left + elem + right + "}"
}