class Solution {
    public boolean isSubsequence(String s, String t) {
        int s_i = 0;
        int t_i = 0;
        while (s_i < s.length() && t_i < t.length()) {
            char c1 = s.charAt(s_i);
            while (t_i < t.length() && t.charAt(t_i) != c1) {
                t_i++;
            }
            if (t_i == t.length()) {
                return false;
            }
            t_i++;
            s_i++;
        }
        return s_i == s.length();
    }
}