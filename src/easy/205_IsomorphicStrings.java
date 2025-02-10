class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> inverse_map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.get(c1) == null) {
                map.put(c1, c2);
                if (inverse_map.get(c2) != null) {
                    return false;
                }
                inverse_map.put(c2, c1);
            } else {
                if (map.get(c1) != c2 || inverse_map.get(c2) != c1) {
                    return false;
                }
            }
        }
        return true;
    }
}