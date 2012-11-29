package week7

object equality {
  class Point(val x: Int, val y: Int) {
  	def == (that: Point) = x == that.x && y == that.y
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(158); 
  
  val p1 = new Point(2,3);System.out.println("""p1  : week7.equality.Point = """ + $show(p1 ));$skip(26); 
  val p2 = new Point(3,2);System.out.println("""p2  : week7.equality.Point = """ + $show(p2 ));$skip(26); 
  val p3 = new Point(2,3);System.out.println("""p3  : week7.equality.Point = """ + $show(p3 ));$skip(14); val res$0 = 
  
  p1 == p2;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(11); val res$1 = 
  p1 == p3;System.out.println("""res1: Boolean = """ + $show(res$1))}
}