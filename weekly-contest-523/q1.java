class Solution {
  public boolean threeFibonacciSum(int n) {
    int fib1 = 0;
    int fib2 = 1;
    int fib3 = 1;
    if (n == 1) {
      return false;
    }
    while (true) {
      if (n == fib1 + fib2 + fib3) {
        return true;
      }
      if (n < fib1 + fib2 + fib3) {
        break;
      }
      int pfib3 = fib3;
      fib3 = fib3 + fib2;
      int pfib2 = fib2;
      fib2 = pfib3;
      fib1 = pfib2;
    }
    return false;
  }
}
