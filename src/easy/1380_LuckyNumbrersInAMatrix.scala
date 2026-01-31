object Solution {
  def luckyNumbers(matrix: Array[Array[Int]]): List[Int] = {
    
    
    def isLucky(i: Int, j: Int): Boolean = {
      return matrix(i)(j) == matrix(i).min
        && matrix(i)(j) == matrix.map(_(j)).max
    }

    (for {
      i <- matrix.indices
      j <- matrix(0).indices
      if isLucky(i, j)
    } yield matrix(i)(j)).toList

  }
}
