class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fibPrev = 1;
        int fibPrevPrev = 0;
        for (int i = 0; i < n - 1; i++) {
            int fib = fibPrev + fibPrevPrev;
            fibPrevPrev = fibPrev;
            fibPrev = fib;
        }
        return fibPrev;
    }
}