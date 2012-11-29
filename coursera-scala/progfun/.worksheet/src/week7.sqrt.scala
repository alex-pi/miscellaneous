package week7

object sqrt {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(214); 

  def sqrtStream(x: Double): Stream[Double] = {
  	def improve(guess: Double) = (guess + x / guess) / 2
  	lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
  	guesses
  };System.out.println("""sqrtStream: (x: Double)Stream[Double]""");$skip(35); val res$0 = 
  
  sqrtStream(4).take(10).toList;System.out.println("""res0: List[Double] = """ + $show(res$0));$skip(95); 

  def isGoodEnough(guess: Double, x: Double) =
  	math.abs((guess * guess - x) / x) < 0.00001;System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(58); val res$1 = 
  sqrtStream(4).filter(isGoodEnough(_,4)).take(10).toList;System.out.println("""res1: List[Double] = """ + $show(res$1))}
}