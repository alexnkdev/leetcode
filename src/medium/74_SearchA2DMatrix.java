class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        int high = matrix.length * matrix[0].length;
        while (lo < high) {
            int mid = (lo + high) / 2;
            int mid_i = mid / matrix[0].length;
            int mid_j = mid % matrix[0].length;
            int val = matrix[mid_i][mid_j];
            if (val == target) {
                return true;
            } else if (val < target) {
                lo = mid + 1;
            } else {
                high = mid;
            }
        }
        return false;
    }
}