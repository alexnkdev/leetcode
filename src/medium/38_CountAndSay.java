class Solution {
    public String countAndSay(int n) {
        String ret = "1";
        for (int i = 0; i < n - 1; i++) {
            ret = apply(ret);
        }
        return ret;
    }

    public String apply(String str) {
        int i = 0;
        String ret = "";
        while (i < str.length()) {
            char c = str.charAt(i);
            int cnt = 0;
            while (i < str.length() && str.charAt(i) == c) {
                cnt++;
                i++;
            }
            ret += String.format("%s%s", cnt, c);
        }
        return ret;
    }
}