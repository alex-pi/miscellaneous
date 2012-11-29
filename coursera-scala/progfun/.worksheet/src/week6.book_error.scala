package week6

object book_error {
  case class Book(title: String, authors: List[String]);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(386); 
  
  val books = Set(
  	Book(title = "Introduction to Functional Programming",
  				authors=List("Bird, Richard", "Wadler, Phil")),
  	Book(title = "Effective Java",
  				authors=List("Bloch, Joshua")),
  	Book(title = "Java Puzzlers",
  				authors=List("Bloch, Joshua", "Gafter, Neal"))
  );System.out.println("""books  : scala.collection.immutable.Set[week6.book_error.Book] = """ + $show(books ))}
}