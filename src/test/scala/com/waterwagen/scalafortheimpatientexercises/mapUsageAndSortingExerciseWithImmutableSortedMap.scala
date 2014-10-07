// Scala
import scala.collection.mutable._
import scala.util._
import scala.collection.JavaConversions._
// Java
import java.awt.datatransfer._
import java.io.File
import java.util.Scanner
import java.util.TreeMap

val scanner = new Scanner(new File("words.txt"))
var wordCountMap = scala.collection.immutable.SortedMap[String,Int]()
//val wordPattern : java.lang.String = "[\\w']+[-]?[\\w']+"
val delimiterPattern = """[\s.?,"()]+"""

scanner.useDelimiter(delimiterPattern)
while(scanner.hasNext) {
  val word = scanner.next.map(_.toLower)
  wordCountMap = wordCountMap + (word -> (wordCountMap.getOrElse(word, 0) + 1))
}

// display results
printf("\n\nWord counts (sorted by word):")
for((word,count) <- wordCountMap.toList) {
  printf("\n%s = %d", word, count)
}

printf("\n\nWord counts (sorted by count):")
val sortedWordCounts = wordCountMap.toList.sortWith((pair1, pair2) => {
  if(pair1._2 != pair2._2) { pair1._2 > pair2._2 } 
  else { pair1._1 < pair2._1 }
})
for((word,count) <- sortedWordCounts) {
  printf("\n%s = %d", word, count)
}

