package algorithms;

public class NumRollsToTarget {
	
	int MOD = (int)1e9+7;
	
	public int numRollsToTarget(int D, int f, int target) {
		int[][] dp = new int[D + 1][target + 1];
		dp[0][0] = 1;
		for (int d = 1; d <= D; d++) {
			for (int t = 1; t <= target; t++) {
				for (int k = 1; k <= f; k++) {
					if (t - k >= 0) {
						dp[d][t] = (dp[d][t] + dp[d - 1][t - k]) % MOD;
					}
				}
			}
		}
		return dp[D][target] % MOD;
	}
	
	public static void main(String[] args) {
		System.out.println(new NumRollsToTarget().numRollsToTarget(30, 30, 500));
	}
}
