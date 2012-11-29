package problems

object ooyala2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(1096); 

// The goal is to write an algorithm which can identify if a given word can be
// constructed via concatenations of words given in a sorted list.
// EG:
//  cat
//  dog
//  doggy
//  gycaz
//  whale
//
// is_cat_construction("whale", sorted_word_list) = true
// is_cat_construction("catcat", sorted_word_list) = true
// is_cat_construction("catca", sorted_word_list) = false
// is_cat_construction("dogcat", sorted_word_list) = true
// is_cat_construction("whalle", sorted_word_list) = false
// is_cat_construction("dogpotatocat", sorted_word_list) = false
// is_cat_construction("doggycaz", sorted_word_list) = true

// corey@ooyala.com
// Ask any engineering related questions. (Nothing about hiring).

	def binarySearch(str: String, xs: List[String]) = {
	    def inner(low: Int, high: Int): Int = {
	    	val middle = (low + high) / 2
	    	if(high < low) -1
	    	else if(xs(middle).compareTo(str) > 0) inner(low, middle - 1)
	    	else if(xs(middle).compareTo(str) < 0) inner(middle + 1, high)
	    	else middle
	    }
	    
	    inner(0, xs.size - 1)
	};System.out.println("""binarySearch: (str: String, xs: List[String])Int""");$skip(67); 

	val sorted_word_list = List("cat","dog","doggy","gycaz","whale");System.out.println("""sorted_word_list  : List[java.lang.String] = """ + $show(sorted_word_list ));$skip(41); val res$0 = 
	
	binarySearch("cat", sorted_word_list);System.out.println("""res0: Int = """ + $show(res$0));$skip(41); val res$1 = 
	binarySearch("gycaz", sorted_word_list);System.out.println("""res1: Int = """ + $show(res$1));$skip(39); val res$2 = 
	binarySearch("dog", sorted_word_list);System.out.println("""res2: Int = """ + $show(res$2));$skip(41); val res$3 = 
	binarySearch("doggy", sorted_word_list);System.out.println("""res3: Int = """ + $show(res$3));$skip(37); val res$4 = 
	binarySearch("c", sorted_word_list);System.out.println("""res4: Int = """ + $show(res$4));$skip(510); 
	
	def is_cat_construction(word: String, wl: List[String]): Boolean =  {
		def find_longest_word(sub: String, idx: Int, longest: Int): Int =
			if(idx > sub.length) longest
			else if(binarySearch(sub.take(idx), wl) != -1) find_longest_word(sub, idx+1, idx)
			else find_longest_word(sub, idx+1, longest)
	  
	  def inner(cut: String): Boolean = {
	  	val idx = find_longest_word(cut,1,-1)
	  	if(idx <= 0) false
	  	else if(cut.drop(idx).isEmpty) true
	  	else inner(cut.drop(idx))
	  }
	  
	  inner(word)
	};System.out.println("""is_cat_construction: (word: String, wl: List[String])Boolean""");$skip(27); 

	
	val xs:String = "hola";System.out.println("""xs  : String = """ + $show(xs ));$skip(11); val res$5 = 
	xs take 1;System.out.println("""res5: String = """ + $show(res$5));$skip(464); val res$6 = 
// is_cat_construction("whale", sorted_word_list) = true
// is_cat_construction("catcat", sorted_word_list) = true
// is_cat_construction("catca", sorted_word_list) = false
// is_cat_construction("dogcat", sorted_word_list) = true
// is_cat_construction("whalle", sorted_word_list) = false
// is_cat_construction("dogpotatocat", sorted_word_list) = false
// is_cat_construction("doggycaz", sorted_word_list) = true

 is_cat_construction("whale", sorted_word_list);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(49); val res$7 = 
 is_cat_construction("catcat", sorted_word_list);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(48); val res$8 = 
 is_cat_construction("catca", sorted_word_list);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(49); val res$9 = 
 is_cat_construction("dogcat", sorted_word_list);System.out.println("""res9: Boolean = """ + $show(res$9));$skip(49); val res$10 = 
 is_cat_construction("whalle", sorted_word_list);System.out.println("""res10: Boolean = """ + $show(res$10));$skip(55); val res$11 = 
 is_cat_construction("dogpotatocat", sorted_word_list);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(51); val res$12 = 
 is_cat_construction("doggycaz", sorted_word_list);System.out.println("""res12: Boolean = """ + $show(res$12))}

}