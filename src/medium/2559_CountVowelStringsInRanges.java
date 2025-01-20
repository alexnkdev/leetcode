class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n + 1];
        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(words[i - 1])) {
                total++;
            }
            prefixSum[i] = total;
        }
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            ret[i] = prefixSum[query[1] + 1] - prefixSum[query[0]];
        }
        return ret;
    }

    boolean isGood(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return isVowel(first) && isVowel(last);
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}