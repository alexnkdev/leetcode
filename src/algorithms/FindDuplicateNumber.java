package algorithms;

public class FindDuplicateNumber {

	public int findDuplicate(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int cnt = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid) {
					cnt++;
				}
			}
			if (cnt > mid) {
				high = mid -1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		System.out.println(new FindDuplicateNumber().findDuplicate(new int[] { 1, 3, 4, 2, 2 } ));
	}
}
