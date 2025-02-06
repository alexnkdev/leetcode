class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] best = new int[n][m];
        best[0][0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                Integer min = null;
                if (i > 0 && (min == null || best[i - 1][j] < min)) {
                    min = best[i - 1][j];
                }
                if (j > 0 && (min == null || best[i][j - 1] < min)) {
                    min = best[i][j - 1];
                }
                best[i][j] = min + grid[i][j];
            }
        }
        return best[n - 1][m - 1];
    }
}