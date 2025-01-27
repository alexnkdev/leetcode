class Solution {

    static int[] di = new int[] { 0, 0, 1, -1 };
    static int[] dj = new int[] { 1, -1, 0, 0 };

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    cnt++;
                    fillIsland(i, j, visited, grid);
                }
            }
        }
        return cnt;
    }

    void fillIsland(int i, int j, boolean[][] visited, char[][] grid) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (ni >= 0 && nj >=0 && ni < grid.length && nj < grid[0].length) {
                if (grid[ni][nj] == '1' && !visited[ni][nj]) {
                    fillIsland(ni, nj, visited, grid);
                }
            }
        }
    }

}