class Solution {
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (true) {
            if (isBalanced(num)) {
                return num;
            }
            num++;
        }
    }
    
    boolean isBalanced(int num) {
        int[] freq = new int[10];
        while (num != 0) {
            int dig = num % 10;
            num /= 10;
            freq[dig]++;
        }
        for (int i = 0; i <= 9; i++) {
            if (freq[i] != 0) {
                if (freq[i] != i) {
                    return false;
                }
            }
        }
        return true;
    }
}
