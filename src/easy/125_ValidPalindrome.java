class Solution {
    public boolean isPalindrome(String s) {
        String trimmed = "";
        for (char c : s.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                trimmed += c;
            }
        }
        return trimmed.equals(new StringBuilder(trimmed).reverse().toString());
    }
}