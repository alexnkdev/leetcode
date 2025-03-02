class Solution {
    public boolean detectCapitalUse(String word) {
        if (isAllCapitals(word)) {
            return true;
        }
        if (isAllNonCapitals(word)) {
            return true;
        }
        if (isOnlyFirstLetterCapital(word)) {
            return true;
        }
        return false;
    }

    boolean isAllCapitals(String word) {
        return word.toUpperCase().equals(word);
    }

    boolean isAllNonCapitals(String word) {
        return word.toLowerCase().equals(word);
    }

    boolean isOnlyFirstLetterCapital(String word) {
        if (word.length() == 0) {
            return false;
        }
        if (!(Character.toUpperCase(word.charAt(0)) == word.charAt(0))) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (Character.toLowerCase(word.charAt(i)) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}