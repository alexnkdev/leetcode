class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int current_i = 0;
        int current_j = 0;
        List<Integer> sorted = new ArrayList<>();
        while (current_i < m && current_j < n) {
            if (nums1[current_i] < nums2[current_j]) {
                sorted.add(nums1[current_i]);
                current_i++;
            } else {
                sorted.add(nums2[current_j]);
                current_j++;
            }
        }
        while (current_i < m) {
            sorted.add(nums1[current_i]);
            current_i++;
        }
        while (current_j < n) {
            sorted.add(nums2[current_j]);
            current_j++;
        }
        for (int i = 0; i < sorted.size(); i++) {
            nums1[i] = sorted.get(i);
        }
    }
}