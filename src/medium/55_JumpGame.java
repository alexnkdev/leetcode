class Solution {
    public boolean canJump(int[] nums) {
       boolean[] reachable = new boolean[nums.length];
       reachable[0] = true;
       for (int i = 1; i < nums.length; i++) {
          reachable[i] = false;
          for (int k = 0; k < i; k++) {
            if (reachable[k] && nums[k] + k >= i) {
                reachable[i] = true;
                break;
            }
          } 
       }
       return reachable[nums.length - 1];
    }
}