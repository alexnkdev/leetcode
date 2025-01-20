package algorithms;

public class P62_UniquePaths {

	public int uniquePaths(int m, int n) {
		int[][] ret = new int[m][n];
		ret[0][0] = 1;
		for (int zeroes = 0; zeroes < m; zeroes++) {
			for (int ones = 0; ones < n; ones++) {
				if (zeroes > 0) {
					ret[zeroes][ones] += ret[zeroes - 1][ones];
				}
				if (ones > 0) {
					ret[zeroes][ones] += ret[zeroes][ones - 1];
				}
			}
		}
		return ret[m - 1][n - 1];
	}

}
