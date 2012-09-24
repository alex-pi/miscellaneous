object FirstWS {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(28); 
  val x = 1;System.out.println("""x  : Int = """ + $show(x ));$skip(31); 
  def increase(i: Int) = i + 1;System.out.println("""increase: (i: Int)Int""");$skip(14); val res$0 = 
  increase(x);System.out.println("""res0: Int = """ + $show(res$0));$skip(24); 
  
  val xs = List(1,3);System.out.println("""xs  : List[Int] = """ + $show(xs ));$skip(10); val res$1 = 
  xs.head;System.out.println("""res1: Int = """ + $show(res$1));$skip(10); val res$2 = 
  xs.tail;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(15); val res$3 = 
  xs.tail.head;System.out.println("""res3: Int = """ + $show(res$3))}
}