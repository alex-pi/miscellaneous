package week6

object books {
	case class Book(title: String, authors: List[String])
  
  val books = Set(
  	Book(title = "Introduction to Functional Programming",
  				authors=List("Bird, Richard", "Wadler, Phil")),
  	Book(title = "Effective Java",
  				authors=List("Bloch, Joshua")),
  	Book(title = "Java Puzzlers",
  				authors=List("Bloch, Joshua", "Gafter, Neal"))
  )                                               //> books  : scala.collection.immutable.Set[week6.books.Book] = Set(Book(Introdu
                                                  //| ction to Functional Programming,List(Bird, Richard, Wadler, Phil)), Book(Eff
                                                  //| ective Java,List(Bloch, Joshua)), Book(Java Puzzlers,List(Bloch, Joshua, Gaf
                                                  //| ter, Neal)))
  
  for (b <- books; a <- b.authors if a startsWith "Bird")
  	yield b                                   //> res0: scala.collection.immutable.Set[week6.books.Book] = Set(Book(Introducti
                                                  //| on to Functional Programming,List(Bird, Richard, Wadler, Phil)))
  //1
  books flatMap ((b:Book) =>
  	for(a <- b.authors if a startsWith "Bird") yield b
  )                                               //> res1: scala.collection.immutable.Set[week6.books.Book] = Set(Book(Introducti
                                                  //| on to Functional Programming,List(Bird, Richard, Wadler, Phil)))
  //2
  books flatMap ((b:Book) =>
  	for(a <- b.authors withFilter (a => a startsWith "Bird")) yield b
  )                                               //> res2: scala.collection.immutable.Set[week6.books.Book] = Set(Book(Introducti
                                                  //| on to Functional Programming,List(Bird, Richard, Wadler, Phil)))
  //3
  books flatMap (b =>
  	b.authors withFilter (a => a startsWith "Bird") map (y => y)
  )                                               //> res3: scala.collection.immutable.Set[String] = Set(Bird, Richard)
    
  //(
  for {
  	b1 <- books
  	b2 <- books
  	if b1 != b2
  	a1 <- b1.authors
  	a2 <- b2.authors
  	if(a1 == a2)
  } yield a1                                      //> res4: scala.collection.immutable.Set[String] = Set(Bloch, Joshua)
  //).distinct
}