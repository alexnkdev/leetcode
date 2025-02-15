class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq1 = freqTable(s);
        int[] freq2 = freqTable(t);
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    int[] freqTable(String s) {
        int[] ret = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ret[s.charAt(i) - 'a']++;
        }
        return ret;
    }
}