object Solution {
  def hammingDistance(x: Int, y: Int): Int = {
    (0 until 32).count { i => 
      ((x >> i) & 1) != ((y >> i) & 1)
    }
  }
}
