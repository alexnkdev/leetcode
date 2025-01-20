class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            boolean good = true;
            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                if (i >= str.length() || !(str.charAt(i) == first.charAt(i))) {
                    good = false;
                    break;
                }
            }
            if (!good) {
                return first.substring(0, i);
            }
        }
        return first;
    }
}