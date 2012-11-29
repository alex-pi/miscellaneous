object pmsort {
  def msort[T](xs: List[T])(lt: (T,T) => Boolean): List[T] = {
  	val n = xs.length / 2
  	if(n == 0) xs
  	else {
			def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
				case (Nil, ys) => ys
				case (xs, Nil) => xs
				case (x :: xs1, y :: ys1) =>
						if(lt(x, y)) x :: merge(xs1, ys)
						else y :: merge(xs, ys1)
			}
  		val (fst,snd) = xs splitAt n
  		merge(msort(fst)(lt), msort(snd)(lt))
  	}
  }                                               //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]
  
  msort(5::4::3::7::2::1::8::Nil)((x,y) => x < y) //> res0: List[Int] = List(1, 2, 3, 4, 5, 7, 8)
  msort("grape"::"pineapple"::"pear"::"orange"::Nil)((x,y) => x.compareTo(y) < 0)
                                                  //> res1: List[java.lang.String] = List(grape, orange, pear, pineapple)
}