package week7

//import week7._

object pouring_test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95); 
  val problem = new Pouring(Vector(2,9));System.out.println("""problem  : week7.Pouring = """ + $show(problem ));$skip(128); val res$0 = 
  
  //problem.pathSets.take(5).toList
                                                  
  problem.solutions(5).take(2).toList;System.out.println("""res0: List[week7.pouring_test.problem.Path] = """ + $show(res$0))}
}