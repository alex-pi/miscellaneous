import sun.security.util.Length

object nqueens {
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
  }                                               //> queens: (n: Int)Set[List[Int]]
  
  def show(queens: List[Int]) = {
  	var lines =
  		for(col <- queens.reverse)
  		yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
  			"\n" + (lines mkString "\n")
  }                                               //> show: (queens: List[Int])java.lang.String
  
  queens(4) map show                              //> res0: scala.collection.immutable.Set[java.lang.String] = Set("
                                                  //| * * X * 
                                                  //| X * * * 
                                                  //| * * * X 
                                                  //| * X * * ", "
                                                  //| * X * * 
                                                  //| * * * X 
                                                  //| X * * * 
                                                  //| * * X * ")
  (queens(8) take 3 map show) mkString "\n"       //> res1: String = "
                                                  //| * * * * X * * * 
                                                  //| * * X * * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * * X * * 
                                                  //| * * * * * * * X 
                                                  //| * X * * * * * * 
                                                  //| * * * X * * * * 
                                                  //| * * * * * * X * 
                                                  //| 
                                                  //| * X * * * * * * 
                                                  //| * * * X * * * * 
                                                  //| * * * * * X * * 
                                                  //| * * * * * * * X 
                                                  //| * * X * * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * * * X * 
                                                  //| * * * * X * * * 
                                                  //| 
                                                  //| * * * X * * * * 
                                                  //| * * * * * X * * 
                                                  //| * * * * * * * X 
                                                  //| * * X * * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * * * X * 
                                                  //| * * * * X * * * 
                                                  //| * X * * * * * * "
}