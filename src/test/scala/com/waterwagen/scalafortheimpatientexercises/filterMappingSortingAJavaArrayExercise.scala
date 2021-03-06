package com.waterwagen

import java.util.TimeZone

object FilterMappingSortingAJavaArrayExercise extends App {
  def printTimeZones(timeZoneIds: Array[String]) {
    for (timeZoneId <- timeZoneIds) {
      printf("%s\n", timeZoneId)
    }
  }

  val americaPrefix = "America/"
  val americanTimezoneIds = TimeZone.getAvailableIDs().filter(_.startsWith(americaPrefix)).map(_.drop(americaPrefix.length)).sorted
  // with prefix
  printf("\nAmerican ids with prefix:\n")
  printTimeZones(TimeZone.getAvailableIDs().filter(_.startsWith(americaPrefix)))
  // without prefix
  printf("\nAmerican ids without prefix:\n")
  printTimeZones(americanTimezoneIds)
}
