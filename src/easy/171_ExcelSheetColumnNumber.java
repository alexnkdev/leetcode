class Solution {
    public int titleToNumber(String columnTitle) {
        int ret = 0;
        for (char c : columnTitle.toCharArray()) {
            int val = (int)(c - 'A' + 1);
            ret = ret * 26 + val;
        }
        return ret;
    }
}