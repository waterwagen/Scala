package com.waterwagen

import java.awt.datatransfer._

import scala.collection.JavaConversions._
import scala.collection.mutable._

object AutomaticJavaConversionExercise extends App {
  val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  val buffer: Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
  printf("flavors: %s", buffer.mkString("[", ",", "]"))
}

