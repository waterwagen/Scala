import scala.collection.mutable._
import scala.util._
import scala.collection.JavaConversions._
import java.awt.datatransfer._

val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
val buffer : Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
printf("flavors: %s", buffer.mkString("[", ",", "]"))

