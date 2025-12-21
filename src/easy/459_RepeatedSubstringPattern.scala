object Solution {
  def repeatedSubstringPattern(s: String): Boolean = {

    val lengths = s.indices.filter(index => s.length % (index + 1) == 0)
    .map(i => i + 1).filter(l => l != s.length)

    return lengths.map(l => s.substring(0, l) * (s.length / l))
        .exists(str => str.equals(s))

  }
}
