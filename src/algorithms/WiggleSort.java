package algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WiggleSort {

	public void wiggleSort(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		List<Integer> leftPart = Arrays.stream(nums).boxed().limit(n / 2 + (n%2)).sorted(Collections.reverseOrder()).collect(Collectors.toList());
		List<Integer> rightPart = Arrays.stream(nums).boxed().skip(n / 2).sorted(Collections.reverseOrder()).collect(Collectors.toList());
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				nums[i] = leftPart.get(i / 2);
			} else {
				nums[i] = rightPart.get(i / 2);
			}
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public static void main(String[] args) {
		new WiggleSort().wiggleSort(new int[] {} );
	}
	
}
