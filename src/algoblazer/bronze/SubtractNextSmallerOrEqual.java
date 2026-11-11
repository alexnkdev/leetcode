class Solution {
    public int[] subtractNextSmallerOrEqual(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                int poppedIndex = st.pop();
                result[poppedIndex] = nums[poppedIndex] - nums[i];
            }
            st.push(i);
        }
        return result;
    }
}
