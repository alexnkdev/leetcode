class Solution {
    public int minimumLength(String s) {
        int ret = s.length();
        for (int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    cnt++;
                }
            }
            if (cnt > 0) {
                int left;
                if (cnt <= 2) {
                    left = cnt;
                } else {
                    left = (cnt + 1) % 2 + 1;
                }
                ret -= cnt - left;
            }
        }
        return ret;
    }
}