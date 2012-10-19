object insets {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
	val t1 = new NonEmpty(3, new Empty, new Empty);System.out.println("""t1  : NonEmpty = """ + $show(t1 ));$skip(20); 
	val t2 = t1 incl 4;System.out.println("""t2  : IntSet = """ + $show(t2 ));$skip(191); 
	
	val ta = new NonEmpty(5, new NonEmpty(3, new Empty, new Empty),
						new NonEmpty(11, new NonEmpty(9, new Empty, new Empty),
														new NonEmpty(12, new Empty, new Empty))
						);System.out.println("""ta  : NonEmpty = """ + $show(ta ));$skip(122); 
						
  val tb = new NonEmpty(2, new NonEmpty(1, new Empty, new Empty),
  								new NonEmpty(3, new Empty, new Empty));System.out.println("""tb  : NonEmpty = """ + $show(tb ));$skip(14); val res$0 = 
  ta union tb;System.out.println("""res0: IntSet = """ + $show(res$0))}
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