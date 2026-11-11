class Solution {
    public int[] nextGreaterForQueries(int[] queries, int[] nums) {
        Stack<Integer> mst = new Stack<Integer>();
        int n = nums.length;
        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            while (!mst.isEmpty() && val > nums[mst.peek()] ) {
                int prev = mst.pop();
                ans.put(nums[prev], nums[i]);
            }
            mst.push(i);
        }
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (ans.containsKey(queries[i])) {
                ret[i] = ans.get(queries[i]);
            } else {
                ret[i] = -1;
            }
        }
        return ret;
    }
}
