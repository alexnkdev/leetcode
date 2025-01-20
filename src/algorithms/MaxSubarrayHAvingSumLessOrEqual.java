package algorithms;

/*
 * 
 * Sliding Window.
 */
public class MaxSubarrayHAvingSumLessOrEqual {

	public int find(int[] nums, int sum) {
		int current = 0;
		int left = 0;
		int ret = 0;
		for (int i = 0; i < nums.length; i++) {
			current = current + nums[i];
			if (current > sum) {
				while (current > sum && left <= i) {
					current = current - nums[left];
					left++;
				}
			}
			ret = Math.max(ret, current);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(new MaxSubarrayHAvingSumLessOrEqual().find(new int[] { 2, 4, 6, 8, 10 } , 7));
	}
}
