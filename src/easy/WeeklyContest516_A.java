class Solution {
    public boolean isPalindromic(String s) {
        String ss = "";
        for (char c : s.toCharArray()) {
            int ch = (int)c;
            String binary = Integer.toString(ch, 2);
            while (binary.length() < 8) {
                binary = "0" + binary;
            }
            ss = ss + binary;
        }
        String reversed = new StringBuilder(ss).reverse().toString();
        return reversed.equals(ss);
        
    }
}
