import scala.annotation.tailrec

object Solution {

  def binaryGap(n: Int): Int = {
    
    @tailrec
    def find(n: Int, pos: Int, prevOne: Int, maxGap: Int): Int = 
      n match {
        case 0 => maxGap
        case _ if (n & 1) == 0 =>
          find(n >> 1, pos + 1, prevOne, maxGap)
        case _ =>
          val newGap = if (prevOne == -1) maxGap else math.max(maxGap, pos - prevOne)
          find(n >> 1, pos + 1, pos, newGap)
      }

    find(n, 0, -1, 0)

  }

}
