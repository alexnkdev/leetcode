class Solution {
    public long calculateScore(String s) {
        Map<Character, Stack<Integer>> places = new HashMap<>();
        long ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int diffFromZ = (int)(c - 'a');
            char mirror = (char)('z' - diffFromZ);
            if (places.get(mirror) != null && !places.get(mirror).isEmpty()) {
                int other = places.get(mirror).pop();
                ret += i - other;
            } else {
                if (places.get(c) == null) {
                    places.put(c, new Stack<Integer>());
                }
                places.get(c).add(i);
            }
        }
        return ret;
    }
}