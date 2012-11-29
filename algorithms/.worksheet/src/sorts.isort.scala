package sorts

object isort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(179); 
  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  	case Nil => x :: Nil
  	case y :: ys => if(y >= x) x :: xs else y :: insert(x, ys)
  };System.out.println("""insert: (x: Int, xs: List[Int])List[Int]""");$skip(118); 

  def isort(xs: List[Int]): List[Int] = xs match {
  	case Nil => List()
  	case y :: ys => insert(y, isort(ys))
  };System.out.println("""isort: (xs: List[Int])List[Int]""");$skip(37); val res$0 = 
  
  isort(5::4::3::7::2::1::8::Nil);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(16); val res$1 = 
  3 :: 4 :: Nil;System.out.println("""res1: List[Int] = """ + $show(res$1))}
}