object map {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(133); 
  def squareList(xs: List[Int]): List[Int] = xs match {
  	case Nil => xs
  	case x :: xt => x * x :: squareList(xt)
  };System.out.println("""squareList: (xs: List[Int])List[Int]""");$skip(72); 
  
  def squareList2(xs: List[Int]): List[Int] =
  	xs map (x => x * x);System.out.println("""squareList2: (xs: List[Int])List[Int]""");$skip(30); val res$0 = 
  
  squareList(1::3::7::Nil);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(28); val res$1 = 
  squareList2(1::3::7::Nil);System.out.println("""res1: List[Int] = """ + $show(res$1))}
}