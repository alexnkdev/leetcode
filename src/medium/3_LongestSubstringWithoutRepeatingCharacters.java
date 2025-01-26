class Solution {
    public int lengthOfLongestSubstring(String s) {
         int i = 0;
         int j = 0;
         Map<Character, Integer> freq = new HashMap<>();
         int ret = 0;
         while (j < s.length()) {
            char c = s.charAt(j);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while (i < j) {
                boolean isGood = true;
                for (Character ch : freq.keySet()) {
                    if (freq.get(ch) > 1) {
                        isGood = false;
                        break;
                    }
                }
                if (isGood) {
                    break;
                }
                freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) - 1);
                i++;
            }
            ret = Math.max(ret, j - i + 1);
            j++;
         }
         return ret;
    }
}