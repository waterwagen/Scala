package com.waterwagen

object NestedVsChainedPackagesExercise extends App {
  val personNested = new com.horstmann.impatient.PackagePersonNested("Josh", "Taylor")
  val personChained = new com.horstmann.impatient.PackagePersonChained("Daniel", "Lombaugh")
  // print
  printf("%s %s", personNested.firstName, personNested.lastName)
  printf("\n%s %s", personChained.firstName, personChained.lastName)
  // execute methods accessing classes in various packages
  personNested.nestedMethod()
  printf("\nran nested method")
  personChained.chainedMethod()
  printf("\nran chained method")
}
