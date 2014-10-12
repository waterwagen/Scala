#!/usr/bin/env scala

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import scala.io.Source

args foreach {
  fileName =>

  val replacementChar : Char = 'z'
  def convertChar(char : Char) : Char = if(char == 'a') { replacementChar } else { char }

  val newContents : String = Source.fromFile(new File(fileName)).map(convertChar(_)).mkString
  printf("Overwriting contents of %s with new contents %s", fileName, newContents)
  Files.write(Paths.get(fileName), newContents.getBytes(StandardCharsets.UTF_8))
}
