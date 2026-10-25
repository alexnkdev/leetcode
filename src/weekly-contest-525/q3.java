class Solution {

    int[][] f;
    
    public int countStaircase(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        f = new int[n + 1][n];
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j < n; j++) {
                f[i][j] = f[i - 1][j];
                if (nums[j] == num) {
                    f[i][j]++;
                }
            }
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                seen.clear();
                boolean good = true;
               
                int expected = 0;
                for (int k = i; k <= j; k++) {
                    int num = nums[k];
                    if (seen.contains(num)) {
                        continue;
                    }
                    expected++;
                    int ff = f[j + 1][k] - f[i][k];
                    if (ff != expected) {
                        good = false;
                        break;
                    }
                    seen.add(num);
                }
                if (good) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
