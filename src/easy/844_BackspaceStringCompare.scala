import scala.collection.mutable.Stack

object Solution {
  def backspaceCompare(s: String, t: String): Boolean = {
    
    def build(str: String): Stack[Char] =
      str.foldLeft(Stack.empty[Char]) {
        case (stack, '#') =>
          if (stack.nonEmpty) stack.pop()
          stack
        case (stack, ch) =>
          stack.push(ch)
          stack
      }

    return build(s) == build(t)

  }
}
