class Solution {
    public int countSegments(String s) {
        int i = 0;
        String current = "";
        int ret = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (!current.isEmpty()) {
                    ret++;
                }
                current = "";
            } else {
                current += c;
            }
            i++;
        }
        if (!current.isEmpty()) {
            ret++;
        }
        return ret;
    }
}