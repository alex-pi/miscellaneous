package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = 
    if(c == 0 || c == r) 1
    else pascal(c-1,r-1) + pascal(c,r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
      
      def check(balance: Int, t: List[Char]): Int =
        if(t.isEmpty || balance < 0) balance
        else if(t.head == ')') check(balance-1, t.tail)
        else if(t.head == '(') check(balance+1, t.tail)
        else check(balance, t.tail)
      
      check(0, chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
