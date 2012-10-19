object natural {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(45); 
  
  val n1 = Zero.successor;System.out.println("""n1  : natural.Succ = """ + $show(n1 ));$skip(37); val res$0 = 
  n1.successor.successor.predecessor;System.out.println("""res0: natural.Nat = """ + $show(res$0));$skip(60); val res$1 = 
  n1.successor.successor + n1.successor.successor.successor;System.out.println("""res1: natural.Nat = """ + $show(res$1))}
 

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