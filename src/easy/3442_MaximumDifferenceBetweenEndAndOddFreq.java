class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Integer ret = null;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (freq[i] > 0 && freq[j] > 0) {
                    if (freq[i] % 2 == 1 && freq[j] % 2 == 0) {
                        ret = ret == null ? freq[i] - freq[j] : Math.max(ret, freq[i] - freq[j]);
                    }
                }
            }
        }
        return ret;
    }
}