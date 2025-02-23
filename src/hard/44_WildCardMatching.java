class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] match = new boolean[n + 1][m + 1];
        match[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                boolean ok = false;
                if (i - 1 >= 0 && p.charAt(j - 1) == '?') {
                    ok |= match[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    for (int k = 0; k <= i; k++) {
                        ok |= match[k][j - 1];
                    }
                } else {
                    if (i - 1 >= 0 && p.charAt(j - 1) == s.charAt(i - 1)) {
                        ok |= match[i - 1][j - 1];
                    }
                }
                match[i][j] = ok;
            }
        }
        return match[n][m];
    }
}