package easy;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cnts.put(nums[i], cnts.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (other == nums[i] && cnts.getOrDefault(other,0) > 1 ||
                other != nums[i] && cnts.getOrDefault(other, 0) > 0) {
                for (int j = 0; j < nums.length; j++) {
                    if (j != i && nums[j] == other) {
                        return new int[] {i, j};
                    }
                }
            }
        }
        return new int[] {};
    }
}