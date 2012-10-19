object exercise2 {
  def sum(f: Int => Int)(a: Int, b: Int): Int =
  	if(a > b) 0 else f(a) + sum(f)(a+1, b)    //> sum: (f: Int => Int)(a: Int, b: Int)Int
  
  sum((x: Int) => x * x)(1, 4)                    //> res0: Int = 30
  
  def product(f: Int => Int)(a: Int, b: Int): Int =
  	if(a > b) 1 else f(a) * product(f)(a+1,b) //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  product(x => x)(1, 4)                           //> res1: Int = 24
  
  def factorial(a: Int): Int =
  	product(x => x)(1, a)                     //> factorial: (a: Int)Int
  
  factorial(4)                                    //> res2: Int = 24
  
  def mapReduce(f: Int => Int, op: (Int, Int) => Int, stop: Int)(a: Int, b: Int): Int =
  	if(a > b) stop else op(f(a), mapReduce(f,op,stop)(a+1,b))
                                                  //> mapReduce: (f: Int => Int, op: (Int, Int) => Int, stop: Int)(a: Int, b: Int)
                                                  //| Int
 
  mapReduce(x => x * x, (x, y) => x + y, 0)(1, 4) //> res3: Int = 30
  
  mapReduce(x => x, (x, y) => x * y, 1)(1, 4)     //> res4: Int = 24
  
  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
                                                  
  product2(x => x)(1, 4)                          //> res5: Int = 24
}