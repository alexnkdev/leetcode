package algorithms;

public class LongestTurbulentSubarray {

	public int maxTurbulenceSize(int[] A) {
		if (A.length < 2) {
			return A.length;
		}
		if (A.length == 2) {
			if (A[0] != A[1]) {
				return 2;
			}
			return 1;
		}
		int n = A.length;
		int left = 0;
		int ret = 1;
		for (int i = 0; i < n - 1; i++) {
			if (A[i] != A[i + 1]) {
				ret = 2;
			}
		}
		for (int i = 2; i < n; i++) {
			int current = A[i];
			int prev = A[i - 1];
			int prevprev = A[i - 2];
			if (isGood(prevprev, prev, current)) {
				ret = Math.max(ret, i - left + 1);
			} else {
				left = i - 1;
			}
		}
		return ret;
	}

	private boolean isGood(int prevprev, int prev, int current) {
		if (prevprev < prev && prev > current) {
			return true;
		}
		if (prevprev > prev && prev < current) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new LongestTurbulentSubarray().maxTurbulenceSize(new int[] { 4,8,12,16 }));
	}

}
