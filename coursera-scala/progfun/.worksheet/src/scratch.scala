import week4._
import week3._

object scratch {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(305); 
  def nth[T](idx: Int, xs: List[T]): T = {
  	def inner[T](n: Int, xs: List[T]): T =
	  	if(xs.isEmpty) throw new IndexOutOfBoundsException("No element found using index: " + idx)
	  	else if(n == 0) xs.head
	  	else inner(n-1, xs.tail)
	  inner(idx,xs)
  };System.out.println("""nth: [T](idx: Int, xs: week4.List[T])T""");$skip(58); 
  	
  val l1 = new Cons(1, new Cons(2, new Cons(3, Nil)));System.out.println("""l1  : week4.Cons[Int] = """ + $show(l1 ));$skip(13); val res$0 = 
  nth(1, l1);System.out.println("""res0: Int = """ + $show(res$0));$skip(27); val res$1 = 
  //nth(3, l1)
  List(1,2);System.out.println("""res1: week4.List[Int] = """ + $show(res$1));$skip(9); val res$2 = 
  List();System.out.println("""res2: week4.Nil.type = """ + $show(res$2));$skip(69); 
       
       
  def f(xs: List[NonEmpty], x: Empty) = xs prepend x;System.out.println("""f: (xs: week4.List[week3.NonEmpty], x: week3.Empty)week4.List[week3.IntSet]""");$skip(66); 
                       
  val e: Expr = Sum(Number(2), Number(3));System.out.println("""e  : week4.Expr = """ + $show(e ));$skip(9); val res$3 = 
  e.eval;System.out.println("""res3: Int = """ + $show(res$3));$skip(9); val res$4 = 
  e.show;System.out.println("""res4: String = """ + $show(res$4));$skip(63); 
  
  val e2: Expr = Prod(Sum(Number(2), Number(3)), Number(4));System.out.println("""e2  : week4.Expr = """ + $show(e2 ));$skip(10); val res$5 = 
  e2.show;System.out.println("""res5: String = """ + $show(res$5));$skip(80); 
  
  val e2a: Expr = Prod(Sum(Number(2), Number(3)), Sum(Number(4), Number(5)));System.out.println("""e2a  : week4.Expr = """ + $show(e2a ));$skip(11); val res$6 = 
  e2a.show;System.out.println("""res6: String = """ + $show(res$6));$skip(95); 
  
  val e3: Expr = Prod(Prod(Sum(Number(2), Number(3)), Sum(Number(4), Number(5))),Number(1));System.out.println("""e3  : week4.Expr = """ + $show(e3 ));$skip(10); val res$7 = 
  e3.show;System.out.println("""res7: String = """ + $show(res$7));$skip(93); 
  
  val e4: Expr = Sum(Prod(Prod(Number(2), Number(3)), Sum(Var("x"), Var("y"))),Number(1));System.out.println("""e4  : week4.Expr = """ + $show(e4 ));$skip(10); val res$8 = 
  e4.show;System.out.println("""res8: String = """ + $show(res$8))}
}