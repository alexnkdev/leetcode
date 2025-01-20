package algorithms;

public class MaxConsecutiveOnesIII {

	public static void main(String[] args) {
		new MaxConsecutiveOnesIII().longestOnes(new int[] { 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 }, 3);
	}
	public int longestOnes(int[] A, int K) {
		int n = A.length;
		int[] totals = new int[n];
		totals[0] = A[0];
		for (int i = 1; i < n; i++) {
			totals[i] = totals[i - 1] + A[i];
		}
		int max = 0;
		int i = 0;
		int j = n - 1;
		while (i < j) {
			int tot = totals[j];
			if (i > 0) {
				tot -= totals[i - 1];
			}
			System.out.println(i + " " + j + " " + tot);
			int len = j - i + 1;
			if (tot + K >= len) {
				break;
			}
			if (A[i] == 0) {
				i++;
			} else if (A[j] == 0) {
				j--;
			} else {
				i++;
			}
		}
		return j - i + 1;
	}
	
}
