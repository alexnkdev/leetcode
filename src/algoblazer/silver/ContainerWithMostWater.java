class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int ret = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            ret = Math.max(ret, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ret;
    }
}
