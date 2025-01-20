package algorithms;

public class LeetCodeMaxIncreaseToKeepSkyline {

	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int[] skylineLeft = new int[grid.length];
		for (int i = 0; i < grid.length; i++) {
			skylineLeft[i] = 0;
			for (int j = 0; j < grid[0].length; j++) {
				skylineLeft[i] = Math.max(skylineLeft[i], grid[i][j]);
			}
		}
		int[] skylineTop = new int[grid[0].length];
		for (int j = 0; j < grid[0].length; j++) {
			skylineTop[j] = 0;
			for (int i = 0; i < grid.length; i++) {
				skylineTop[j] = Math.max(skylineTop[j], grid[i][j]);
			}
		}
		String s;
		int ans = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				int maxPossible = Math.min(skylineTop[j], skylineLeft[i]);
				ans = ans + (maxPossible - grid[i][j]);
			}
		}
        return ans;
    }
	
}
