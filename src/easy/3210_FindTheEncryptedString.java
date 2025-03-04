class Solution {
    public String getEncryptedString(String s, int k) {
        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            char replacement = s.charAt((i + k) % s.length());
            ret += replacement;
        }
        return ret;
    }
}