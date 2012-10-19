object exercise2 {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(108); 
  def sum(f: Int => Int)(a: Int, b: Int): Int =
  	if(a > b) 0 else f(a) + sum(f)(a+1, b);System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(34); val res$0 = 
  
  sum((x: Int) => x * x)(1, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(100); 
  
  def product(f: Int => Int)(a: Int, b: Int): Int =
  	if(a > b) 1 else f(a) * product(f)(a+1,b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(27); val res$1 = 
  
  product(x => x)(1, 4);System.out.println("""res1: Int = """ + $show(res$1));$skip(59); 
  
  def factorial(a: Int): Int =
  	product(x => x)(1, a);System.out.println("""factorial: (a: Int)Int""");$skip(18); val res$2 = 
  
  factorial(4);System.out.println("""res2: Int = """ + $show(res$2));$skip(152); 
  
  def mapReduce(f: Int => Int, op: (Int, Int) => Int, stop: Int)(a: Int, b: Int): Int =
  	if(a > b) stop else op(f(a), mapReduce(f,op,stop)(a+1,b));System.out.println("""mapReduce: (f: Int => Int, op: (Int, Int) => Int, stop: Int)(a: Int, b: Int)Int""");$skip(52); val res$3 = 
 
  mapReduce(x => x * x, (x, y) => x + y, 0)(1, 4);System.out.println("""res3: Int = """ + $show(res$3));$skip(49); val res$4 = 
  
  mapReduce(x => x, (x, y) => x * y, 1)(1, 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(95); 
  
  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""product2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(76); val res$5 = 
                                                  
  product2(x => x)(1, 4);System.out.println("""res5: Int = """ + $show(res$5))}
}