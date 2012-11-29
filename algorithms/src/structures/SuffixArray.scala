package structures

class SuffixArray(text: String){
	val suffixArray:Array[String] = text.tails.toArray.sorted
	
	val longestRepeatedString = ((0 until suffixArray.length-1) foldLeft ""){case (accu, idx) =>
   		val pre = lcp(idx, idx+1)
   		if(accu.length < pre) suffixArray(idx).take(pre)
   		else accu
	}
	
	val longestCommonString = ((0 until suffixArray.length-1) foldLeft ""){case (accu, idx) =>
   		val pre = lcp(idx, idx+1)
   		if(accu.length < pre) suffixArray(idx).take(pre)
   		else accu
	}	

	def lcp(i: Int, j: Int) = {	  
	  def inner(sa: String, sb:String, accu:Int): Int =
	  	if(sa.isEmpty() || sb.isEmpty() || sa.head != sb.head) accu
	  	else inner(sa.tail, sb.tail, accu+1)
	  	
	  inner(suffixArray(i), suffixArray(j), 0)
	}	 
	
	override def toString() = suffixArray mkString "\n"	
}

object app extends App {
	val sa = new SuffixArray("CAGTCAGG")
	val sb = new SuffixArray("CAGTCAGG&TCAAGCTGA")

	//println(sa.longestRepeatedString)
	println(sb)
}