object msort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(232); 

	def merge2(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
		case (Nil, ys) => ys
		case (xs, Nil) => xs
		case (x :: xs1, y :: ys1) =>
				if(x < y) x :: merge2(xs1, ys)
				else y :: merge2(xs, ys1)
	};System.out.println("""merge2: (xs: List[Int], ys: List[Int])List[Int]""");$skip(221); 

	def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
		case Nil => ys
		case x :: xs1 => ys match {
			case Nil => xs
			case y :: ys1 =>
				if(x < y) x :: merge(xs1, ys)
				else y :: merge(xs, ys1)
		}
	};System.out.println("""merge: (xs: List[Int], ys: List[Int])List[Int]""");$skip(173); 
	
  def msort(xs: List[Int]): List[Int] = {
  	val n = xs.length / 2
  	if(n == 0) xs
  	else {
  		val (fst,snd) = xs splitAt n
  		merge2(msort(fst), msort(snd))
  	}
  };System.out.println("""msort: (xs: List[Int])List[Int]""");$skip(37); val res$0 = 
  
  msort(5::4::3::7::2::1::8::Nil);System.out.println("""res0: List[Int] = """ + $show(res$0))}
}