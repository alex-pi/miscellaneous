object session {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(188); 
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
  	def loop(a: Int, acc: Int): Int = {
  		if(a > b) return acc
  		else loop(a+1, f(a) + acc)
  	}
  	
  	loop(a, 0)
  };System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(30); val res$0 = 
  
  sum((x: Int) => x)(1, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(31); val res$1 = 
  sum((x: Int) => x * x)(1, 4);System.out.println("""res1: Int = """ + $show(res$1));$skip(67); val res$2 = 
  sum({def f(x: Int): Int = if(x == 0) 1 else x * f(x-1);f})(1, 4);System.out.println("""res2: Int = """ + $show(res$2))}
}