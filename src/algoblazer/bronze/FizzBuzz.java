class Solution {
  public String[] fizzBuzz(int n) {
    String[] ret = new String[n];
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        ret[i - 1] = "FizzBuzz";
      } else if (i % 3 == 0) {
        ret[i - 1] = "Fizz";
      } else if (i % 5 == 0) {
        ret[i - 1] = "Buzz";
      } else {
        ret[i - 1] = "" + i;
      }
    }
    return ret;
  }
}
