package sorts

object quicksort {
  val nums = List(22,31,45,13,12,11,52,31,37,5)   //> nums  : List[Int] = List(22, 31, 45, 13, 12, 11, 52, 31, 37, 5)
  
  val part = nums partition (x => x < nums.head)  //> part  : (List[Int], List[Int]) = (List(13, 12, 11, 5),List(22, 31, 45, 52, 3
                                                  //| 1, 37))
  nums span (x => x > 13)                         //> res0: (List[Int], List[Int]) = (List(22, 31, 45),List(13, 12, 11, 52, 31, 37
                                                  //| , 5))
  val mapa = nums groupBy (x => x < nums.head)    //> mapa  : scala.collection.immutable.Map[Boolean,List[Int]] = Map(false -> Lis
                                                  //| t(22, 31, 45, 52, 31, 37), true -> List(13, 12, 11, 5))

	
  def quicksort(xs: List[Int]): List[Int] =
  	if(xs.length < 2) xs
  	else {
  		val (left, right) = xs partition (x => x < xs.head)
  		quicksort(left) ::: (xs.head :: quicksort(right.tail))
  	}                                         //> quicksort: (xs: List[Int])List[Int]
	
	quicksort(nums)                           //> res1: List[Int] = List(5, 11, 12, 13, 22, 31, 31, 37, 45, 52)
}