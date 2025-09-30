class Solution {
    public int triangularSum(int[] nums) {
        int[] previousRow = nums;
        for (int rowIndex = 1; rowIndex < nums.length; rowIndex++) {
            int[] newRow = new int[nums.length - rowIndex];
            for (int i = 0; i < newRow.length; i++) {
                newRow[i] = (previousRow[i] + previousRow[i + 1]) % 10;
            }    
            previousRow = newRow;
        }
        return previousRow[0];
    }
}
