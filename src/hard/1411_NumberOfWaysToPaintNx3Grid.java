class Solution {
    public int numOfWays(int n) {
        
        long MOD = 1000000007;

        int max = 3 * 3 * 3;

        long[][] dp = new long[n][max];

        for (int enc = 0; enc < max; enc++) {
            if (ok_hor(enc)) {
                dp[0][enc] = 1;
            }
        }


        for (int i = 1; i < n; i++) {

            for (int prev_row = 0; prev_row < max; prev_row++) {
                for (int current_row = 0; current_row < max; current_row++) {
                    if (!ok_hor(current_row)) {
                        continue;
                    }
                   if (ok(prev_row, current_row)) {
                    dp[i][current_row] = (dp[i][current_row] + dp[i - 1][prev_row]) % MOD; 
                   }  
                }
            }
        }

        long ret = 0;
        for (int enc = 0; enc < max; enc++) {
            ret = (ret + dp[n - 1][enc]) % MOD;
        }
        return (int) ret;
    }

    boolean ok_hor(int row) {
        int[] dec = decode(row);
        for (int i = 1; i < 3; i++) {
            if (dec[i] == dec[i - 1]) {
                return false;
            }
        }
        return true;
    }

    boolean ok(int prev_row, int current_row) {
        int[] dec_prev = decode(prev_row);
        int[] dec_current = decode(current_row);
        for (int i = 0; i < 3; i++) {
            if (dec_prev[i] == dec_current[i]) {
                return false;
            }
        }
        return true;
    }

    int[] decode(int row) {
        int[]rr = new int[3];
        rr[0] = row % 3;
        row /= 3;
        rr[1] = row % 3;
        row /= 3;
        rr[2] = row % 3;
        return rr;
    }
}
