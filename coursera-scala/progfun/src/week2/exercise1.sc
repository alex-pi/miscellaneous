object session {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
  	def loop(a: Int, acc: Int): Int = {
  		if(a > b) return acc
  		else loop(a+1, f(a) + acc)
  	}
  	
  	loop(a, 0)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int
  
  sum((x: Int) => x)(1, 4)                        //> res0: Int = 10
  sum((x: Int) => x * x)(1, 4)                    //> res1: Int = 30
  sum({def f(x: Int): Int = if(x == 0) 1 else x * f(x-1);f})(1, 4)
                                                  //> res2: Int = 33
}