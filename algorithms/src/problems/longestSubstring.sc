package problems

import structures.SuffixArray

object longestSubstring {
  var t1 = "Welcome to the Scala worksheet"       //> t1  : java.lang.String = Welcome to the Scala worksheet
  var t2 = "CAGTCAGG"                             //> t2  : java.lang.String = CAGTCAGG
  var t3 = t2+"#"+"TCAAGCTGA"                     //> t3  : java.lang.String = CAGTCAGG#TCAAGCTGA
  
  t1.reverse                                      //> res0: String = teehskrow alacS eht ot emocleW
  
  val lol = t1.tails map ((e) => e+"$")           //> lol  : Iterator[java.lang.String] = non-empty iterator
  
  val sa = new SuffixArray(t2)                    //> sa  : structures.SuffixArray = 
                                                  //| AGG
                                                  //| AGTCAGG
                                                  //| CAGG
                                                  //| CAGTCAGG
                                                  //| G
                                                  //| GG
                                                  //| GTCAGG
                                                  //| TCAGG
  sa.longestRepeatedString                        //> res1: java.lang.String = CAG
  
  val sa2 = new SuffixArray(t3)                   //> sa2  : structures.SuffixArray = 
                                                  //| #TCAAGCTGA
                                                  //| A
                                                  //| AAGCTGA
                                                  //| AGCTGA
                                                  //| AGG#TCAAGCTGA
                                                  //| AGTCAGG#TCAAGCTGA
                                                  //| CAAGCTGA
                                                  //| CAGG#TCAAGCTGA
                                                  //| CAGTCAGG#TCAAGCTGA
                                                  //| CTGA
                                                  //| G#TCAAGCTGA
                                                  //| GA
                                                  //| GCTGA
                                                  //| GG#TCAAGCTGA
                                                  //| GTCAGG#TCAAGCTGA
                                                  //| TCAAGCTGA
                                                  //| TCAGG#TCAAGCTGA
                                                  //| TGA
}