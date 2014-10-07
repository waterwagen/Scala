package com {

  class ThisIsAComPackageClass()

  package horstmann {

    class ThisIsAHorstmannPackageClass()

    package impatient {
      class PackagePersonNested(val firstName : String, val lastName : String) {
        def nestedMethod() {
          val comClass = new ThisIsAComPackageClass() // can get to this because this is in a nested package declaration
          val horstmannClass = new ThisIsAHorstmannPackageClass() // can get to this because this is in a nested package declaration
          val impatientClass = new PackagePersonChained("Jane", "Smith") // can get to this even though this is in a nested package declaration
        }
      }
    }
  }
}

package com.horstmann.impatient {
  
  class PackagePersonChained(val firstName : String, val lastName : String) {

    def chainedMethod() {
      val comClass = new com.ThisIsAComPackageClass() // can't get to this without explicitly specifying the package because this class is in a chained package declaration
      val horstmannClass = new com.horstmann.ThisIsAHorstmannPackageClass() // can't get to this without explicitly specifying the package because this class is in a chained package declaration
      val impatientClass = new PackagePersonNested("John", "Doe") // CAN get to this even though this is in a chained package declaration
    }
  }
}

