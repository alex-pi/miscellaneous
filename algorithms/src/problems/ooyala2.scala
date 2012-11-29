package problems

object ooyala2 extends App{

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
  	
	def is_word_construction(word: String, wl: List[String]): Boolean =  {		
		def recursive(sub: String): Boolean = 
			if(sub.isEmpty) true
			else {
				(1 to sub.length).toList exists ( (split:Int) =>
				  	binarySearch(sub take split, wl) != -1 && recursive(sub drop split)
				  )
			}
					
		recursive(word)		
	}
	
	  val ordered1 = List("cas", "cat","dog","dogg","doggy","gycaz","whale", "ycaz")
	  
	  println(ooyala2.is_word_construction("catdog", ordered1))
	  println(ooyala2.is_word_construction("catcat", ordered1))
	  println(ooyala2.is_word_construction("catca", ordered1))
	  println(ooyala2.is_word_construction("dogcat", ordered1))
	  println(ooyala2.is_word_construction("dogpotatocat", ordered1))
	  println(ooyala2.is_word_construction("doggycaz", ordered1))
	  println(ooyala2.is_word_construction("doggycas", ordered1))
	  println(ooyala2.is_word_construction("doggycazdo", ordered1))
	  println(ooyala2.is_word_construction("doggycazdog", ordered1))	
}

