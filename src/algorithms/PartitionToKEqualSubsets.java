package algorithms;

public class PartitionToKEqualSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
        	totalSum += nums[i];
        }
        int partSum = totalSum / k;
        if (partSum * k != totalSum) {
        	return false;
        }
        System.out.println(partSum);
        return rec(nums, 0, partSum);
    }
    
    boolean rec(int[] nums, int mask, int requiredSum) {
    	if (mask == (1 << nums.length) - 1) {
    		return true;
    	} else {
    		boolean result = false;
    		for (int subset = 0; subset < (1 << nums.length); subset++) {
    			int totalSum = 0;
    			boolean ok = true;
    			for (int i = 0; i < nums.length; i++) {
    				if ((subset & (1 << i)) > 0) {
    					totalSum += nums[i];
    					if ((mask & (1 << i)) != 0) {
    						ok = false;
    					}
    				}
    			}
    			if (ok && totalSum == requiredSum) {
    				result |= rec(nums, mask | subset, requiredSum);
    				if (result) {
    					break;
    				}
    			}
    		}
    		return result;
    	}
    }
    
    public static void main(String[] args) {
    	System.out.println(new PartitionToKEqualSubsets().canPartitionKSubsets(new int[] { 10, 10, 7, 7, 6, 6 }, 2));
    }
    
}
