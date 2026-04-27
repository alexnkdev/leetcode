class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            boolean okLeft = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    okLeft = false;
                    break;
                }
            }

            boolean okRight = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    okRight = false;
                    break;
                }
            }

            if (okLeft || okRight) {
                ret.add(nums[i]);
            }
        }
        return ret;
    }
}
