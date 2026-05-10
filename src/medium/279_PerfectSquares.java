class Solution {
    public int numSquares(int n) {
        int[] ret = new int[n + 1];
        ret[0] = 0;
        for (int i = 1; i <= n; i++) {
            ret[i] = ret[i - 1] + 1;
            for (int j = 1; j * j <= i; j++) {
                ret[i] = Math.min(ret[i], ret[i - j * j] + 1);
            }
        }
        return ret[n];
    }
}
