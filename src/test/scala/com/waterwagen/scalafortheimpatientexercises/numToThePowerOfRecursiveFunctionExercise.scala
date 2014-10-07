import scala.math._

def numToPowerOf(num : Int, power : Int) : Long = {
  if(power == 0) { 1 }
  else if(power < 0) { 1 / numToPowerOf(num, abs(power)) }
  else if(power % 2 != 0) { num * numToPowerOf(num, power - 1) }
  else { val y = numToPowerOf(num, power/2); y * y }
}

for(num <- 0 to 10; power <- 0 to 10) {
  val result = numToPowerOf(num, power)
  printf("%d to the power of %d == %d \n", num, power, result)
}
