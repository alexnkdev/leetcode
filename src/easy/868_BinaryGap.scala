import scala.annotation.tailrec

object Solution {
  
  def binaryGap(n: Int): Int = {
  
    @tailrec
    def find(n: Int, currentPos: Int, prevOne: Int, max: Int): Int = {
      if (n == 0) {
        max
      } else {
        if (n % 2 == 0) {
          find(n / 2, currentPos + 1, prevOne, max)
        } else {
          find(n / 2, currentPos + 1, currentPos,
            if (prevOne == -1) 0 else math.max(max, currentPos - prevOne) )
        }
      }
    }

    find(n, 0, -1, 0)
  }

}
