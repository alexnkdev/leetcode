package algorithms;

public class MaxLengthOfRepeated {

	public int findLength(int[] A, int[] B) {
		int[][] dp = new int[A.length][B.length];
		int ret = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					if (i > 0 && j > 0) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = 1;
					}
				} else {
					dp[i][j] = 0;
				}
				ret = Math.max(ret, dp[i][j]);
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(new MaxLengthOfRepeated().findLength(new int[] { 1,2,3,2,1}, new int[] { 3,2,1,4,7}));
	}

}
