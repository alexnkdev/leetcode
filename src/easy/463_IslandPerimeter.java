class Solution {
    public int islandPerimeter(int[][] grid) {
        int ret = 0;
        int[] di = new int[] { 0, 0, 1, -1 };
        int[] dj = new int[] { 1, -1, 0, 0 };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int edges = 0;
                for (int k = 0; k < 4; k++) {
                    int ni = i + di[k];
                    int nj = j + dj[k];
                    if (ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length || grid[ni][nj] == 0) {
                        edges++;
                    }
                }
                ret += edges;
            }
        }
        return ret;
    }
}