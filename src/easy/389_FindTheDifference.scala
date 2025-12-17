object Solution {
    def findTheDifference(s: String, t: String): Char = {
        val freq_s: Map[Char, Int] =
            s.groupBy(identity).view.mapValues(_.length).toMap
        val freq_t: Map[Char, Int] =
            t.groupBy(identity).view.mapValues(_.length).toMap
        freq_t.keySet.find(k => freq_s.getOrElse(k, 0) != freq_t.getOrElse(k, 0)).get
    }
}
