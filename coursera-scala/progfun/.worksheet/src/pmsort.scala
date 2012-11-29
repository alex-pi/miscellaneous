object pmsort {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(439); 
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
  };System.out.println("""msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]""");$skip(53); val res$0 = 
  
  msort(5::4::3::7::2::1::8::Nil)((x,y) => x < y);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(82); val res$1 = 
  msort("grape"::"pineapple"::"pear"::"orange"::Nil)((x,y) => x.compareTo(y) < 0);System.out.println("""res1: List[java.lang.String] = """ + $show(res$1))}
}