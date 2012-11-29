package mathalgs

object gcd {
	def gcd(a : Int, b : Int) : Int = {
	  def gcd_(a: Int, b : Int) : Int = {
	    (a,b) match {
	      case (_,0) => a
	      case (0,_) => b
	      case (_,_) => gcd_(math.min(a,b), math.abs(a - b))
	    }
	  }
	  gcd_(math.abs(a),math.abs(b))
	}                                         //> gcd: (a: Int, b: Int)Int

	gcd(15,35)                                //> res0: Int = 5
	
	def gcd2(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
                                                  //> gcd2: (a: Int, b: Int)Int
	
	gcd2(15,35)                               //> res1: Int = 5
}