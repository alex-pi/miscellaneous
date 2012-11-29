package sorts

object quicksort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
  val nums = List(22,31,45,13,12,11,52,31,37,5);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(52); 
  
  val part = nums partition (x => x < nums.head);System.out.println("""part  : (List[Int], List[Int]) = """ + $show(part ));$skip(26); val res$0 = 
  nums span (x => x > 13);System.out.println("""res0: (List[Int], List[Int]) = """ + $show(res$0));$skip(47); 
  val mapa = nums groupBy (x => x < nums.head);System.out.println("""mapa  : scala.collection.immutable.Map[Boolean,List[Int]] = """ + $show(mapa ));$skip(201); 

	
  def quicksort(xs: List[Int]): List[Int] =
  	if(xs.length < 2) xs
  	else {
  		val (left, right) = xs partition (x => x < xs.head)
  		quicksort(left) ::: (xs.head :: quicksort(right.tail))
  	};System.out.println("""quicksort: (xs: List[Int])List[Int]""");$skip(19); val res$1 = 
	
	quicksort(nums);System.out.println("""res1: List[Int] = """ + $show(res$1))}
}