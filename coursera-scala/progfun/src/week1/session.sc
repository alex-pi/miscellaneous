object session {
  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double
  abs(-19)                                        //> res0: Double = 19.0

  def sqrt(x: Double) = {

    def newton(guess: Double): Double =
      if (isGood(guess)) guess
      else newton(improve(guess))

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def isGood(guess: Double) =
      abs(guess * guess - x) / x < 0.0001

    newton(1.0)

  }                                               //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res1: Double = 1.4142156862745097
  sqrt(4)                                         //> res2: Double = 2.0000000929222947
  sqrt(1e-6)                                      //> res3: Double = 0.0010000001533016628
  sqrt(1e60)                                      //> res4: Double = 1.0000000031080746E30
}