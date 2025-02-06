class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] paths = new int[n][m];
        paths[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                int sum = 0;
                if (i > 0 && obstacleGrid[i - 1][j] != 1) {
                    sum += paths[i - 1][j];
                }
                if (j > 0 && obstacleGrid[i][j - 1] != 1) {
                    sum += paths[i][j - 1];
                }
                paths[i][j] = sum;
            }
        }
        return paths[n - 1][m - 1];
    }
}