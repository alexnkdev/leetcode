object Solution {
  def maximumProduct(nums: Array[Int]): Int = {
    val triples = for {
      i <- nums.indices
      j <- i + 1 until nums.length
      k <- j + 1 until nums.length
    } yield nums(i) * nums(j) * nums(k)

    triples.foldLeft(Option.empty[Int]) {
      case (None, p) => Some(p)
      case (Some(m), p) => Some(math.max(m, p))
    }.get
  }
}
