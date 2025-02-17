class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int n = pattern.length();
        int m = words.length;
        if (n != m) {
            return false;
        }
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String word = words[i];
            Character letter = pattern.charAt(i);
            if (charToWord.containsKey(letter) && !charToWord.get(letter).equals(word)) {
                return false;
            }
            if (wordToChar.containsKey(word) && !wordToChar.get(word).equals(letter)) {
                return false;
            }
            charToWord.put(letter, word);
            wordToChar.put(word, letter);
        }
        return true;
    }
}