class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String trimmed = "";
        for (char c : s.toCharArray()) {
            if (c != '-') {
                trimmed += Character.toUpperCase(c);
            }
        }
        int groups = (int) Math.ceil(trimmed.length() / k);
        int firstGroupLength = trimmed.length() % k;
        String formatted = "";
        for (int i = 0; i < Math.min(firstGroupLength, s.length()); i++) {
            formatted += trimmed.charAt(i);
        }
        if (!formatted.isEmpty() && groups > 0) {
            formatted += "-";
        }
        for (int g = 0; g < groups; g++) {
            for (int kk = 0; kk < k; kk++) {
                formatted += trimmed.charAt(firstGroupLength + g * k + kk);
            }
            if (g < groups - 1) {
                formatted += "-";
            }
        }
        return formatted;
    }
}