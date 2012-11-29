object book_error {
  case class Book(title: String, authors: List[String])import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(371); 
  
  val books = Set(
  	Book(title = "Introduction to Functional Programming",
  				authors=List("Bird, Richard", "Wadler, Phil")),
  	Book(title = "Effective Java",
  				authors=List("Bloch, Joshua")),
  	Book(title = "Java Puzzlers",
  				authors=List("Bloch, Joshua", "Gafter, Neal"))
  );System.out.println("""books  : scala.collection.immutable.Set[book_error.Book] = """ + $show(books ))}
}