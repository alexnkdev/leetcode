class Solution {

    static int[] di = new int[] { 0, 0, 1, -1 };
    static int[] dj = new int[] { 1, -1, 0, 0 };

    public int findMaxFish(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    int area = calcArea(grid, i, j, visited);
                    ret = Math.max(ret, area);
                }
            }
        }
        return ret;
    }

    int calcArea(int[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int ret = grid[i][j];
        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length) {
                if (!visited[ni][nj] && grid[ni][nj] > 0) {
                    ret += calcArea(grid, ni, nj, visited);
                }
            }
        }
        return ret;
    }
}