class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int tot = 0;
        for (Character c : freq.keySet()) {
            tot += freq.get(c) / 2;
        }
        int rem = s.length() > tot * 2 ? 1 : 0;
        return tot * 2 + rem;
    }
}