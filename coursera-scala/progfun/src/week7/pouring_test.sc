package week7

//import week7._

object pouring_test {
  val problem = new Pouring(Vector(2,9))          //> problem  : week7.Pouring = week7.Pouring@4bbd7848
  
  //problem.pathSets.take(5).toList
                                                  
  problem.solutions(5).take(2).toList             //> res0: List[week7.pouring_test.problem.Path] = List(Fill(1) Pour(1,0) Empty(0
                                                  //| ) Pour(1,0)--> Vector(2, 5), Fill(1) Pour(1,0) Empty(0) Pour(1,0) Empty(0)--
                                                  //| > Vector(0, 5))
}