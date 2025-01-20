package algorithms;

public class ArrayNesting {

	public int arrayNesting(int[] nums) {
		boolean[] used = new boolean[nums.length];
		int ret = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				int k = nums[i];
				int cycle = 1;
				while (k != i) {
					used[k] = true;
					k = nums[k];
					cycle++;
				}
				ret = Math.max(ret, cycle);
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(new ArrayNesting().arrayNesting(new int[] { 0, 1, 2, 3 } ));
	}
}
