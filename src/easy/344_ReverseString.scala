object Solution {
    def reverseString(s: Array[Char]): Unit = {
        (0 until s.length / 2).foreach { i =>
            val tmp = s(s.length - i - 1)
            s(s.length - i - 1) = s(i)
            s(i) = tmp
        }
    }
}
