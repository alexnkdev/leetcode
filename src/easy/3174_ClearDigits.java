class Solution {
    public String clearDigits(String s) {
        boolean[] del = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                del[i] = true;
                for (int j = i - 1; j >= 0; j--) {
                    char cprev = s.charAt(j);
                    if (!(cprev >= '0' && cprev <= '9') && !del[j]) {
                        del[j] = true;
                        break;
                    }
                }
            }
        }
        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            if (!del[i]) {
                ret += s.charAt(i);
            }
        }
        return ret;
    }
}