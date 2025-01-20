package algorithms;

public class SplitIntoConsecutive {

	public boolean isPossible(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			int current = nums[i];
			i++;
		}
		return false;
	}

	public static void main(String[] args) {
		new SplitIntoConsecutive().isPossible(new int[] { 1, 2, 3, 3, 4, 5});
	}
}
