package week6

object books {
	case class Book(title: String, authors: List[String]);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(380); 
  
  val books = Set(
  	Book(title = "Introduction to Functional Programming",
  				authors=List("Bird, Richard", "Wadler, Phil")),
  	Book(title = "Effective Java",
  				authors=List("Bloch, Joshua")),
  	Book(title = "Java Puzzlers",
  				authors=List("Bloch, Joshua", "Gafter, Neal"))
  );System.out.println("""books  : scala.collection.immutable.Set[week6.books.Book] = """ + $show(books ));$skip(72); val res$0 = 
  
  for (b <- books; a <- b.authors if a startsWith "Bird")
  	yield b;System.out.println("""res0: scala.collection.immutable.Set[week6.books.Book] = """ + $show(res$0));$skip(93); val res$1 = 
  //1
  books flatMap ((b:Book) =>
  	for(a <- b.authors if a startsWith "Bird") yield b
  );System.out.println("""res1: scala.collection.immutable.Set[week6.books.Book] = """ + $show(res$1));$skip(108); val res$2 = 
  //2
  books flatMap ((b:Book) =>
  	for(a <- b.authors withFilter (a => a startsWith "Bird")) yield b
  );System.out.println("""res2: scala.collection.immutable.Set[week6.books.Book] = """ + $show(res$2));$skip(96); val res$3 = 
  //3
  books flatMap (b =>
  	b.authors withFilter (a => a startsWith "Bird") map (y => y)
  );System.out.println("""res3: scala.collection.immutable.Set[String] = """ + $show(res$3));$skip(133); val res$4 = 
    
  //(
  for {
  	b1 <- books
  	b2 <- books
  	if b1 != b2
  	a1 <- b1.authors
  	a2 <- b2.authors
  	if(a1 == a2)
  } yield a1;System.out.println("""res4: scala.collection.immutable.Set[String] = """ + $show(res$4))}
  //).distinct
}