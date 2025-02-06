class Solution {
    public int uniquePaths(int n, int m) {
        int[][] paths = new int[n][m];
        paths[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int sum = 0;
                if (i > 0) {
                    sum += paths[i - 1][j];
                }
                if (j > 0) {
                    sum += paths[i][j - 1];
                }
                paths[i][j] = sum;
            }
        }
        return paths[n - 1][m - 1];
    }
}