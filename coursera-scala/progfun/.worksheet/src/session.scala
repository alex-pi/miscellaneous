object session {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(11); val res$0 = 
  abs(-19);System.out.println("""res0: Double = """ + $show(res$0));$skip(294); 

  def sqrt(x: Double) = {

    def newton(guess: Double): Double =
      if (isGood(guess)) guess
      else newton(improve(guess))

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def isGood(guess: Double) =
      abs(guess * guess - x) / x < 0.0001

    newton(1.0)

  };System.out.println("""sqrt: (x: Double)Double""");$skip(11); val res$1 = 

  sqrt(2);System.out.println("""res1: Double = """ + $show(res$1));$skip(10); val res$2 = 
  sqrt(4);System.out.println("""res2: Double = """ + $show(res$2));$skip(13); val res$3 = 
  sqrt(1e-6);System.out.println("""res3: Double = """ + $show(res$3));$skip(13); val res$4 = 
  sqrt(1e60);System.out.println("""res4: Double = """ + $show(res$4))}
}