import scala.math._

import scala.collection.mutable.ArrayBuffer

def printArrayBuffer(nums : ArrayBuffer[Int]) = {
  for(num <- nums) {
    printf("Num is %d \n", num)
  }
}

val nums = new ArrayBuffer(5) += (1,2,3,4,5)

// in order
printf("All the array elements, in order:\n")
printArrayBuffer(nums)

// every other element
printf("\nEvery other element:\n")
for(index <- 0 until (nums.length, 2)) {
  printf("Num is %d \n", nums(index))
}

// all elements in reverse
printf("\nAll the array elements, in reverse:\n")
printArrayBuffer(nums.reverse)

// all elements multiplied by 2
val numsTimesTwo = for(num <- nums) yield num * 2 
printf("\nOriginal array elements times 2, in order:\n")
printArrayBuffer(numsTimesTwo)

// even elements multiplied by 2
val evenNumsTimesTwo = for(num <- nums if num % 2 == 0) yield num * 2 
printf("\nOriginal even array elements times 2, in order:\n")
printArrayBuffer(evenNumsTimesTwo)

// functional calculations of even elements multiplied by 3
val functionalEvenNumsTimesTwo = nums.filter(_ % 2 == 0).map(_ * 3)
printf("\nFunctional calculation of original even array elements times 3, in order:\n")
printArrayBuffer(functionalEvenNumsTimesTwo)

// all negatives but the first removed
val arrayBufferWithNegatives = new ArrayBuffer() += (0, -5, -2, 1, 4, -4, 7, -5)
var foundFirstNegative = false
def filter = (num : Int) => if(num < 0) { val result = !foundFirstNegative; foundFirstNegative = true; result } else { true }
val arrayWithFirstNegative = arrayBufferWithNegatives.filter(filter)
printf("\n%s with all negatives but first removed:\n", arrayBufferWithNegatives)
printArrayBuffer(arrayWithFirstNegative)

// sorted
printf("\n%s sorted in descending order:\n", arrayBufferWithNegatives)
printArrayBuffer(arrayBufferWithNegatives.sortWith(_ > _))

// summed
printf("\n%s summed = %d \n", arrayBufferWithNegatives, arrayBufferWithNegatives.sum)
