object lists {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(180); 
  def init[T](xs: List[T]): List[T] = xs match {
  	case Nil => throw new Error("Init of empty list")
  	case x :: Nil => List()
  	case y :: ys => y :: init(ys)
  };System.out.println("""init: [T](xs: List[T])List[T]""");$skip(153); 
  
  def last[T](xs: List[T]): T = xs match {
  	case Nil => throw new Error("Last of empty list")
  	case x :: Nil => x
  	case y :: ys => last(ys)
  };System.out.println("""last: [T](xs: List[T])T""");$skip(158); 
  
  // Is not lineal :( <-- sad face
  def reverse[T](xs: List[T]): List[T] = xs match {
  	case Nil => List()
  	case y :: ys => reverse(ys) ++ List(y)
  };System.out.println("""reverse: [T](xs: List[T])List[T]""");$skip(145); 
  
  def removeAt[T](xs: List[T], n: Int): List[T] = xs match {
  	case Nil => xs
  	case y :: ys => if(n==0) ys else y :: removeAt(ys, n-1)
  };System.out.println("""removeAt: [T](xs: List[T], n: Int)List[T]""");$skip(84); 
  
  def removeAt2[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n+1);System.out.println("""removeAt2: [T](n: Int, xs: List[T])List[T]""");$skip(384); 
  
/*  def flatten(xs: List[Any]): List[Any] = xs match {
  	case List() => xs
  	case y :: ys => y match {
  		case z :: zs => flatten(z :: zs) ::: flatten(ys)
  		case y => y :: flatten(ys)
  	}
  }
  */
  
	 def flatten(xs: List[Any]): List[Any] = xs match {
	    case Nil => xs
	    case (y:List[Any]) :: ys => flatten(y) ::: flatten(ys)
	    case y :: ys => y :: flatten(ys)
	 };System.out.println("""flatten: (xs: List[Any])List[Any]""");$skip(36); val res$0 = 
  
  init(5::4::3::7::2::1::8::Nil);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(33); val res$1 = 
  last(5::4::3::7::2::1::8::Nil);System.out.println("""res1: Int = """ + $show(res$1));$skip(36); val res$2 = 
  reverse(5::4::3::7::2::1::8::Nil);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(40); val res$3 = 
  removeAt(5::4::3::7::2::1::8::Nil,10);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(41); val res$4 = 
  removeAt2(1, 5::4::3::7::2::1::8::Nil);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(67); val res$5 = 
  flatten(List(1,2,List('a','b','c'),3, List(4,5, List('y','z'))));System.out.println("""res5: List[Any] = """ + $show(res$5))}
                                                  
                                                    
}