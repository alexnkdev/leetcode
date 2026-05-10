class Solution {

    static int MOD = 1000000007;

    public int findPaths(int n, int m, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
       Long[][][] dd = new Long[n][m][maxMove];
       dd[startRow][startColumn][0] = 1L;
       int[] di = new int[] { 0, 0, 1, -1 };
       int[] dj = new int[] { 1, -1, 0, 0 };
       for (int move = 1; move < maxMove; move++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dd[i][j][move] = 0L;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
                            if (dd[ni][nj][move - 1] != null) {
                                dd[i][j][move] = (dd[i][j][move] + dd[ni][nj][move - 1]) % MOD;
                            }
                        }
                    }
                }
            }
       }
       long ret = 0;
       for (int move = 1; move <= maxMove; move++) {
       for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (i == 0 || j == 0 || i == n - 1 || j == m -1) {
                if (dd[i][j][move - 1] != null) {
                    if (i - 1 < 0) {
                        ret = (ret + dd[i][j][move - 1]) % MOD;
                    }
                    if (j - 1 < 0) {
                        ret = (ret + dd[i][j][move - 1]) % MOD;
                    }
                    if (i + 1 == n) {
                        ret = (ret + dd[i][j][move - 1]) % MOD;
                    }
                    if (j + 1 == m) {
                        ret = (ret + dd[i][j][move - 1]) % MOD;
                    }
                }
            }
        }
       }
       }
       return (int) ret;
    }

}
