package structures

abstract class RBTree {
    val rb:Char
	def insert(x: Int): RBTree
	def contains(x: Int): Boolean
}

class Empty extends RBTree {
    val rb = 'b'
    def insert(x: Int) = new NonEmpty(x, 'r', new Empty, new Empty)
    def contains(x: Int) = false
}

class NonEmpty(elem: Int, val rb: Char, left: RBTree, right: RBTree) extends RBTree {
	def insert(x: Int) = new Empty
	
	def contains(x: Int) = 
	  if(x < elem) left contains x
	  else if(x > elem) right contains x
	  else true
}