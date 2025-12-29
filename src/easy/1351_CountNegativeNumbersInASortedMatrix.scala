object Solution {
  def countNegatives(grid: Array[Array[Int]]): Int = {
    grid.flatten.count { _ < 0 }
  }
}
