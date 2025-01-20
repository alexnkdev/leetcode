class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    isPalindrome[i][j] = true;
                    continue;
                }
                if (j == i - 1) {
                    isPalindrome[j][i] = true;
                    continue;
                }
                char _end = s.charAt(i - 1);
                char _start = s.charAt(j);
                boolean isPali = false;
                if (_start == _end) {
                    isPali |= isPalindrome[j + 1][i - 1];
                }
                isPalindrome[j][i] = isPali;
            }
        }
        String maxStr = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) {
                if (isPalindrome[i][j]) {
                    int len = j - i;
                    if (len > maxStr.length()) {
                        maxStr = s.substring(i, j);
                    }
                }
            }
        }
        return maxStr;
    } 
}