class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int j = i;
            while (j < s.length() && s.charAt(j) == c) {
                j++;
            }
            if (j - i == k) {
                return true;
            }
            i = j;
        }
        return false;
    }
}