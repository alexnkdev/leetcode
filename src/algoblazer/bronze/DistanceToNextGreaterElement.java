class Solution {
    public int[] distanceToNextGreater(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            while (!st.isEmpty() && val > nums[st.peek()]) {
                int poppedIndex = st.pop();
                result[poppedIndex] = i - poppedIndex;
            }
            st.push(i);
        }
        return result;
    }
}
