package problems

object nqueens {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(569); 
  def queens(n: Int): Set[List[Int]] = {
  	def placeQueens(k: Int): Set[List[Int]] =
  		if(k == 0) Set(List())
  		else {
  			for {
  				queens <- placeQueens(k-1)
  				col <- 0 until n
  				if isSafe(col, queens)
  			} yield col :: queens
  		}
  		
  	def isSafe(col: Int, queens: List[Int]): Boolean = {
  		val row = queens.length
  		val queensWithRow = (row - 1 to 0 by -1) zip queens
  		queensWithRow forall {
  			case (r,c) => col != c && math.abs(col - c) != math.abs(row - r)
  		}
    }
    
    placeQueens(n)
  };System.out.println("""queens: (n: Int)Set[List[Int]]""");$skip(192); 
  
  def show(queens: List[Int]) = {
  	var lines =
  		for(col <- queens.reverse)
  		yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
  			"\n" + (lines mkString "\n")
  };System.out.println("""show: (queens: List[Int])java.lang.String""");$skip(24); val res$0 = 
  
  queens(4) map show;System.out.println("""res0: scala.collection.immutable.Set[java.lang.String] = """ + $show(res$0));$skip(44); val res$1 = 
  (queens(8) take 3 map show) mkString "\n";System.out.println("""res1: String = """ + $show(res$1))}
}