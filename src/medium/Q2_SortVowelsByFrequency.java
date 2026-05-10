class Solution {
    public String sortVowels(String s) {
        List<Character> ordered_vowels = new ArrayList<>();
        Integer[] first_pos = new Integer[26];
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            if (first_pos[s.charAt(i) - 'a'] == null) {
                first_pos[s.charAt(i) - 'a'] = i;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                ordered_vowels.add(ch);
            }
        }

        ordered_vowels.sort((ch1, ch2) -> {
            if (freq[ch1 - 'a'] > freq[ch2 - 'a']) {
                return -1;
            } else if (freq[ch1 - 'a'] < freq[ch2 - 'a']) {
                return 1;
            } else {
                int fs1 = first_pos[ch1 - 'a'];
                int fs2 = first_pos[ch2 - 'a'];
                if (fs1 < fs2) {
                    return -1;
                } else if (fs1 > fs2) {
                    return 1;
                }
                return 0;
            }
        });
        
        StringBuilder ret = new StringBuilder();
        int cc = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                ret.append(ordered_vowels.get(cc));
                cc++;
            } else {
                ret.append("" + ch);
            }
        }
        return ret.toString();
    }

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
