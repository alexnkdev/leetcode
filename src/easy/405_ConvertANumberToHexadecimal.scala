object Solution {
  def toHex(num: Int): String = {
    val digits = "0123456789abcdef"

    def loop(x: Int, n: Int): List[Char] =
      if (n == 0) Nil
      else digits(x & 0xf) :: loop(x >>> 4, n - 1)

    val full = loop(num, 8).reverse.mkString

    full.dropWhile(_ == '0') match {
      case "" => "0"
      case s  => s
    }

  }
}
