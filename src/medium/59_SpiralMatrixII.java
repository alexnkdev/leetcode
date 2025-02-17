class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int current = 1;
        int i = 0;
        int j = 0;
        int d = 0;
        int[] di = { 0, 1, 0, -1 };
        int[] dj = { 1, 0, -1, 0 };
        while (current <= n * n) {
            ret[i][j] = current;
            if (current == n * n) {
                break;
            }
            while (true) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (ni >= 0 && nj >= 0 && ni < n && nj < n 
                && ret[ni][nj] == 0) {
                    i = ni;
                    j = nj;
                    current++;
                    break;
                } else {
                    d = (d + 1) % di.length;
                }
            }
        }
        return ret;
    }
}