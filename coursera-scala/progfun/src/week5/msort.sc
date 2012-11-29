object msort {

	def merge2(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
		case (Nil, ys) => ys
		case (xs, Nil) => xs
		case (x :: xs1, y :: ys1) =>
				if(x < y) x :: merge2(xs1, ys)
				else y :: merge2(xs, ys1)
	}                                         //> merge2: (xs: List[Int], ys: List[Int])List[Int]

	def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
		case Nil => ys
		case x :: xs1 => ys match {
			case Nil => xs
			case y :: ys1 =>
				if(x < y) x :: merge(xs1, ys)
				else y :: merge(xs, ys1)
		}
	}                                         //> merge: (xs: List[Int], ys: List[Int])List[Int]
	
  def msort(xs: List[Int]): List[Int] = {
  	val n = xs.length / 2
  	if(n == 0) xs
  	else {
  		val (fst,snd) = xs splitAt n
  		merge2(msort(fst), msort(snd))
  	}
  }                                               //> msort: (xs: List[Int])List[Int]
  
  msort(5::4::3::7::2::1::8::Nil)                 //> res0: List[Int] = List(1, 2, 3, 4, 5, 7, 8)
}