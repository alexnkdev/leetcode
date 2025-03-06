class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length() - 1;
        List<List<String>> partitions = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            int i = 0;
            String current = "";
            List<String> set = new ArrayList<>();
            while (i < n + 1) {
                boolean splitHere = i < n && (mask & (1 << i)) > 0;
                current += s.charAt(i);
                if (splitHere) {
                    set.add(current);
                    current = "";
                }
                i++;
            }
            if (current.length() > 0) {
                set.add(current);
            }
            if (isGood(set)) {
                partitions.add(set);
            }
        }
        return partitions;
    }

    boolean isGood(List<String> set) {
        for (String x : set) {
            if (!isPalindrome(x)) {
                return false;
            }
        }
        return true;
    }

    boolean isPalindrome(String s) {
        for (int k = 0; k < s.length() / 2; k++) {
            if (s.charAt(k) != s.charAt(s.length() - k - 1)) {
                return false;
            }
        }
        return true;
    }
}