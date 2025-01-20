package algorithms;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int cnt = map.getOrDefault(nums[i], 0);
			map.put(nums[i], cnt+1);
		}
		for (Integer x : map.keySet()) {
			if (map.get(x) == 1) {
				return x;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new SingleNumberII().singleNumber(new int[] { 3,3,3,15,1,1,1}));
	}

}
