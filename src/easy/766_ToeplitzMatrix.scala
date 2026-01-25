object Solution {
  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    (for {
      i <- 1 until matrix.length
      j <- 1 until matrix(0).length
    } yield matrix(i)(j) == matrix(i - 1)(j - 1)
    )
    .forall(identity)
  }
}
