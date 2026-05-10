class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mm) {
        int m = n;

        int[][] mines = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mines[i][j] = 1;
            }
        }
        for (int i = 0; i < mm.length; i++) {
            mines[mm[i][0]][mm[i][1]] = 0;
        }

        int[][] dl = new int[n][m];
        int[][] du = new int[n][m];
        int[][] dr = new int[n][m];
        int[][] dd = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mines[i][j] != 0) {
                    dl[i][j] = j - 1 >= 0 ? (dl[i][j - 1] + 1) : 1;
                    du[i][j] = i - 1 >= 0 ? (du[i - 1][j] + 1) : 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
               if (mines[i][j] != 0) {
                    dr[i][j] = j + 1 < m ? (dr[i][j + 1] + 1) : 1;
                    dd[i][j] = i + 1 < n ? (dd[i + 1][j] + 1) : 1;
                } 
            }
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mines[i][j] == 1) {
                    int max_left = j - 1 >= 0 ? dl[i][j - 1] : 0;
                    int max_up = i - 1 >= 0 ? du[i - 1][j] : 0;
                    int max_right = j + 1 < m ? dr[i][j + 1] : 0;
                    int max_down = i + 1 < n ? dd[i + 1][j] : 0;
                    int sz = max_left;
                    sz = Math.min(sz, max_up);
                    sz = Math.min(sz, max_right);
                    sz = Math.min(sz, max_down);
                    sz = sz + 1;
                    ret = Math.max(ret, sz);
                }
            }
        }

        return ret;
    }
}
