object books {
  case class Book(title: String, authors: List[String])import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(379); 
  
  val books: List[Book] = List(
  	Book(title = "Introduction to Functional Programming",
  				authors=List("Bird, Richard", "Wadler, Phil")),
  	Book(title = "Effective Java",
  				authors=List("Bloch, Joshua")),
  	Book(title = "Java Puzzlers",
  				authors=List("Bloch, Joshua", "Gafter, Neal"))
  );System.out.println("""books  : List[books.Book] = """ + $show(books ));$skip(72); val res$0 = 
  
  for (b <- books; a <- b.authors if a startsWith "Bird")
  	yield b;System.out.println("""res0: List[books.Book] = """ + $show(res$0))}
}