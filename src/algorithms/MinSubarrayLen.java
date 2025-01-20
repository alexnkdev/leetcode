package algorithms;

import java.util.Arrays;

public class MinSubarrayLen {

	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] sums = new int[nums.length];
		sums[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}
		System.out.println(Arrays.toString(sums));
		Integer ret = null;
		for (int from = 0; from < nums.length; from++) {
			int lowestOk = binarySearch(nums, sums, from, nums.length - 1, s);
			if (lowestOk >= 0) {
				int len = lowestOk - from + 1;
				ret = ret == null ? len : Math.min(ret, len);
			}
		}
		return ret != null ? ret : 0;
	}

	
	private int binarySearch(int[] nums, int[] sums, int from, int to, int s) {
		int low = from;
		int high = to;
		int ans = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int sum = from > 0 ? sums[mid] - sums[from - 1] : sums[mid];
			if (sum >= s) {
				high = mid - 1;
				ans = mid;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		System.out.println(new MinSubarrayLen().minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
	}
}
