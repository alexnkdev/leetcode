class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] num_in_row = new int[n];
        int[] num_in_column = new int[m];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    cnt++;
                }
            }
            num_in_row[i] = cnt;
        }
        for (int j = 0; j < m; j++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] > 0) {
                    cnt++;
                }
            }
            num_in_column[j] = cnt;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    if (num_in_row[i] > 1 || num_in_column[j] > 1) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }
}