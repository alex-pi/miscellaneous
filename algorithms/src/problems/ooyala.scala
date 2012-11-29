package problems

object ooyala extends App{
  
	type Solution = List[String]

	def binarySearch(str: String, xs: List[String]) = {
	    def inner(low: Int, high: Int): Int = {
	    	val middle = (low + high) / 2
	    	if(high < low) -1
	    	else if(xs(middle).compareTo(str) > 0) inner(low, middle - 1)
	    	else if(xs(middle).compareTo(str) < 0) inner(middle + 1, high)
	    	else middle
	    }
	    
	    inner(0, xs.size - 1)
	} 
  	
	def get_word_construction(word: String, wl: List[String]): List[Solution] =  {		
		def recursive(sub: String): List[Solution] = 
			if(sub.isEmpty) List(List())
			else {
				((1 to sub.length) foldLeft List[Solution]()) { case (accu:List[Solution], split:Int) =>
				  	val idx = binarySearch(sub take split, wl)
				  	if(idx != -1) {
				  	  val rest = recursive(sub drop split)
				  	  if(rest.isEmpty) accu
				  	  else (wl(idx) :: rest.head) :: accu
				  	} else accu
				  }
			}
					
		recursive(word)
		
	}
	
	  val ordered1 = List("cas", "cat","dog","dogg","doggy","gycaz","whale", "ycaz")
	  
	  println(ooyala.get_word_construction("catdog", ordered1))
	  println(ooyala.get_word_construction("catcat", ordered1))
	  println(ooyala.get_word_construction("catca", ordered1))
	  println(ooyala.get_word_construction("dogcat", ordered1))
	  println(ooyala.get_word_construction("dogpotatocat", ordered1))
	  println(ooyala.get_word_construction("doggycaz", ordered1))
	  println(ooyala.get_word_construction("doggycas", ordered1))
	  println(ooyala.get_word_construction("doggycazdo", ordered1))
	  println(ooyala.get_word_construction("doggycazdog", ordered1))	
}

