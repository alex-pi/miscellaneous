package sorts

import sorts._

object scratch {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  val v1 = Vector(1,2,3,4);System.out.println("""v1  : scala.collection.immutable.Vector[Int] = """ + $show(v1 ));$skip(35); 
  val v2 = Vector(8,3,4,6,2,5,7,9);System.out.println("""v2  : scala.collection.immutable.Vector[Int] = """ + $show(v2 ));$skip(17); 
  val p1 = (1,2);System.out.println("""p1  : (Int, Int) = """ + $show(p1 ));$skip(13); val res$0 = 
  
  v1.tail;System.out.println("""res0: scala.collection.immutable.Vector[Int] = """ + $show(res$0));$skip(47); 
  
  val h = new Heap(Vector(8,3,4,6,2,5,7,9));System.out.println("""h  : sorts.Heap = """ + $show(h ));$skip(45); val res$1 = 
	//h.fixFrom(Vector(8,3,4,6))
	
	v1 drop 1+2;System.out.println("""res1: scala.collection.immutable.Vector[Int] = """ + $show(res$1))}
}