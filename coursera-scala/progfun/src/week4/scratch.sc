import week4._
import week3._

object scratch {
  def nth[T](idx: Int, xs: List[T]): T = {
  	def inner[T](n: Int, xs: List[T]): T =
	  	if(xs.isEmpty) throw new IndexOutOfBoundsException("No element found using index: " + idx)
	  	else if(n == 0) xs.head
	  	else inner(n-1, xs.tail)
	  inner(idx,xs)
  }                                               //> nth: [T](idx: Int, xs: week4.List[T])T
  	
  val l1 = new Cons(1, new Cons(2, new Cons(3, Nil)))
                                                  //> l1  : week4.Cons[Int] = week4.Cons@26544ec1
  nth(1, l1)                                      //> res0: Int = 2
  //nth(3, l1)
  List(1,2)                                       //> res1: week4.List[Int] = week4.Cons@19968e23
  List()                                          //> res2: week4.Nil.type = week4.Nil$@6b4da8f4
       
       
  def f(xs: List[NonEmpty], x: Empty) = xs prepend x
                                                  //> f: (xs: week4.List[week3.NonEmpty], x: week3.Empty)week4.List[week3.IntSet]
                       
  val e: Expr = Sum(Number(2), Number(3))         //> e  : week4.Expr = Sum(Number(2),Number(3))
  e.eval                                          //> res3: Int = 5
  e.show                                          //> res4: String = 2 + 3
  
  val e2: Expr = Prod(Sum(Number(2), Number(3)), Number(4))
                                                  //> e2  : week4.Expr = Prod(Sum(Number(2),Number(3)),Number(4))
  e2.show                                         //> res5: String = (2 + 3) * 4
  
  val e2a: Expr = Prod(Sum(Number(2), Number(3)), Sum(Number(4), Number(5)))
                                                  //> e2a  : week4.Expr = Prod(Sum(Number(2),Number(3)),Sum(Number(4),Number(5)))
  e2a.show                                        //> res6: String = (2 + 3) * (4 + 5)
  
  val e3: Expr = Prod(Prod(Sum(Number(2), Number(3)), Sum(Number(4), Number(5))),Number(1))
                                                  //> e3  : week4.Expr = Prod(Prod(Sum(Number(2),Number(3)),Sum(Number(4),Number(5
                                                  //| ))),Number(1))
  e3.show                                         //> res7: String = (2 + 3) * (4 + 5) * 1
  
  val e4: Expr = Sum(Prod(Prod(Number(2), Number(3)), Sum(Var("x"), Var("y"))),Number(1))
                                                  //> e4  : week4.Expr = Sum(Prod(Prod(Number(2),Number(3)),Sum(Var(x),Var(y))),Nu
                                                  //| mber(1))
  e4.show                                         //> res8: String = 2 * 3 * (x + y) + 1
}