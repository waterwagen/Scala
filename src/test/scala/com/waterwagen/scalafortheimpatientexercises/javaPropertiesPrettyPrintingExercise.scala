// Scala
import scala.collection.mutable._
import scala.util._
import scala.collection.JavaConversions._
import scala.math._
// Java
import java.util.Calendar

val javaProperties : Map[String,String] = System.getProperties
val maxPropertyNameLength = javaProperties.keySet.foldLeft(0)((g,p) => max(g,p.length))
val formatString = new StringBuilder().append("%-").append(maxPropertyNameLength).append("s").append(" | %s\n").toString
for((propertyName, propertyValue) <- javaProperties) {
  printf(formatString, propertyName, propertyValue)
}

