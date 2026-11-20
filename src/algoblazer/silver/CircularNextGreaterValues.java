class Solution {

  public int[] circularNextGreaterValues(int[] nums) {
    
    Stack<Integer> mst = new Stack<>();
    int[] ret = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      ret[i] = -1;
    }

    for (int i = 0; i < nums.length; i++) {
      int currentIdx = i;
      while (!mst.isEmpty() && (nums[mst.peek()] < nums[currentIdx])) {
        int poppedIdx = mst.pop();
        ret[poppedIdx] = nums[i];
      }
      mst.push(currentIdx);
    }

    for (int i = 0; i < nums.length; i++) {
      int currentIdx = i;
      while (!mst.isEmpty() && (nums[mst.peek()] < nums[currentIdx])) {
        int poppedIdx = mst.pop();
        ret[poppedIdx] = nums[i];
      }
    }


    return ret;

  }

}
