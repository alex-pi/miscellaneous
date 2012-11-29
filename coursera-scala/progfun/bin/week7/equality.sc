package week7

object equality {
  class Point(val x: Int, val y: Int) {
  	def == (that: Point) = x == that.x && y == that.y
  }
  
  val p1 = new Point(2,3)                         //> p1  : week7.equality.Point = week7.equality$Point@6686fe26
  val p2 = new Point(3,2)                         //> p2  : week7.equality.Point = week7.equality$Point@7b2be1bd
  val p3 = new Point(2,3)                         //> p3  : week7.equality.Point = week7.equality$Point@7df17e77
  
  p1 == p2                                        //> res0: Boolean = false
  p1 == p3                                        //> res1: Boolean = true
}