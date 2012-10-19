object natural {
  
  val n1 = Zero.successor                         //> n1  : natural.Succ = 1
  n1.successor.successor.predecessor              //> res0: natural.Nat = 2
  n1.successor.successor + n1.successor.successor.successor
                                                  //> res1: natural.Nat = 7
 

	abstract class Nat {
		def isZero: Boolean
		def predecessor: Nat
		def successor: Nat
		def + (that: Nat): Nat
		def - (that: Nat): Nat
	  override def toString = (this.toInt).toString
	  def toInt(): Int
	}
	
	class Succ(n: Nat) extends Nat {
	  def isZero = false
	  def predecessor = n
	  def successor: Nat = new Succ(this)
	  def + (that: Nat): Nat =
	    if(that.isZero) this
	  	else this.successor + that.predecessor
	  def - (that: Nat): Nat =
	    if(that.isZero) this
	  	else this.predecessor - that.predecessor
	  
	  def toInt() = 1+predecessor.toInt()
	}
	
	object Zero extends Nat {
	  def isZero = true
	  def predecessor: Nothing = throw new NoSuchElementException("Zero.Predecessor")
	  def successor = new Succ(Zero)
		def + (that: Nat): Nat = that
		def - (that: Nat): Nothing = throw new NoSuchElementException("Zero.-")
		
	  def toInt() = 0
	}
}