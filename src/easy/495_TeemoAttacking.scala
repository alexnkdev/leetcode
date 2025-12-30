object Solution {
  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
    if (timeSeries.isEmpty) 0
    else
      timeSeries
        .sliding(2)
        .collect { case Array(a, b) => math.min(duration, b - a) }
        .sum + (if (timeSeries.nonEmpty) duration else 0)
  }
}
