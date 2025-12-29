
object Solution {
  def findComplement(num: Int): Int = {
    
    Integer.parseInt(
      num.toBinaryString.map {
        case '0' => '1'
        case '1' => '0'
      },
    2)

  }
}
