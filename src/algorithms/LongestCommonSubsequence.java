package algorithms;

public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String text1, String text2) {
		int n = text1.length();
		int m = text2.length();
		int[][] dp = new int[n][m];
		dp[0][0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i][j] = (i - 1 >= 0 && j - 1 >= 0) ? dp[i - 1][j - 1] + 1 : 1;
					if (i - 1 >= 0) {
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
					}
					if (j - 1 >= 0) {
						dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
					}
				} else {
					if (i - 1 >= 0) {
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
					}
					if (j - 1 >= 0) {
						dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
					}
				}
			}
		}
		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {
		System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "def"));
	}
}
