class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int ans = 0;
        for (int set = 0; set < (1 << n); set++) {
            int sc = 0;
            Map<Character, Integer> rem = new HashMap<>();
            for (int i = 0; i < letters.length; i++) {
                rem.put(letters[i], rem.getOrDefault(letters[i], 0) + 1);
            }
            boolean good = true;
            for (int i = 0; i < n; i++) {
                if ((set & (1 << i)) != 0) {
                    for (int j = 0; j < words[i].length(); j++) {
                        if (!rem.containsKey(words[i].charAt(j)) || rem.get(words[i].charAt(j)) == 0) {
                            good = false;
                            break;
                        }
                        rem.put(words[i].charAt(j), rem.get(words[i].charAt(j)) - 1);
                        sc += score[words[i].charAt(j) - 'a'];
                    }
                }
            }
            if (good) {
                ans = Math.max(ans, sc);
            }
        }
        return ans;
    }
}