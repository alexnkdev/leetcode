package algorithms;

public class SearchInRotatedArray {

	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int pivot = findPivot(nums, 0, nums.length - 1);
		return pivot;
	}

	private int findPivot(int[] nums, int left, int right) {
		System.out.println("left = " + left + " right = " + right + " " + nums[right] + " " + nums[left]);
		if (nums[right] > nums[left]) {
			return -1;
		}
		int mid = (left + right) / 2;
		System.out.println("mid  = " + mid);
		int pivot1 = findPivot(nums, left, mid);
		int pivot2 = findPivot(nums, mid + 1, right);
		return pivot1 != -1 ? pivot1 : pivot2;
	}

	public static void main(String[] args) {
		System.out.println(new SearchInRotatedArray().search(new int[] { 4, 5, 6, 7, 0, 1, 2} , 0));
	}

}
