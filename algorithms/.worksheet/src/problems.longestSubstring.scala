package problems

import structures.SuffixArray

object longestSubstring {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(118); 
  var t1 = "Welcome to the Scala worksheet";System.out.println("""t1  : java.lang.String = """ + $show(t1 ));$skip(22); 
  var t2 = "CAGTCAGG";System.out.println("""t2  : java.lang.String = """ + $show(t2 ));$skip(30); 
  var t3 = t2+"#"+"TCAAGCTGA";System.out.println("""t3  : java.lang.String = """ + $show(t3 ));$skip(16); val res$0 = 
  
  t1.reverse;System.out.println("""res0: String = """ + $show(res$0));$skip(43); 
  
  val lol = t1.tails map ((e) => e+"$");System.out.println("""lol  : Iterator[java.lang.String] = """ + $show(lol ));$skip(34); 
  
  val sa = new SuffixArray(t2);System.out.println("""sa  : structures.SuffixArray = """ + $show(sa ));$skip(27); val res$1 = 
  sa.longestRepeatedString;System.out.println("""res1: java.lang.String = """ + $show(res$1));$skip(35); 
  
  val sa2 = new SuffixArray(t3);System.out.println("""sa2  : structures.SuffixArray = """ + $show(sa2 ))}
}