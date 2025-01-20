package algorithms;

public class LongestPalindromicSubstring {
    
    Boolean[][] mem;
    
    public String longestPalindrome(String s) {
        int ret = 0;
        String ret_s = "";
        mem = new Boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > ret) {
                        ret = j - i + 1;
                        ret_s = s.substring(i, j + 1);
                    }
                }
            }
        }    
        return ret_s;
    }
    
    public boolean isPalindrome(String s, int i, int j) {
        if (mem[i][j] != null) {
            return mem[i][j];
        }
        if (i == j) {
            return true;
        }
        if (j == i + 1) {
            return s.charAt(i) == s.charAt(j);
        }
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        boolean ret = isPalindrome(s, i + 1, j - 1);
        mem[i][j] = ret;
        return ret;
    }
    
}
