import java.util.Map;

class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    int wordLength = words[0].length();

    Set<String> wordsSet = new HashSet<>();
    for (int i = 0; i < words.length; i++) {
      wordsSet.add(words[i]);
    }

    Map<String, Integer> originalFrequencyMap = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      originalFrequencyMap.put(words[i], originalFrequencyMap.getOrDefault(words[i], 0) + 1);
    }

    List<Integer> goodIndexes = new ArrayList<>();

    for (int startingIndex = 0; startingIndex < wordLength; startingIndex++) {

      List<String> tokens = splitToTokens(s, startingIndex, wordLength);
      if (tokens.size() < words.length) {
        continue;
      }

      int left = 0;
      int right = 0;

      Map<String, Integer> windowFrequencyMap = new HashMap<>();

      while (left < tokens.size()) {
        int numTokensInWindow = right - left;
        if (numTokensInWindow < words.length) {
          String tokenToAdd = tokens.get(right);
          if (wordsSet.contains(tokenToAdd)) {
            windowFrequencyMap.put(tokenToAdd, windowFrequencyMap.getOrDefault(tokenToAdd, 0) + 1);
          }
          right++;
        } else {
          if (right < tokens.size()) {
            // remove left
            String tokenToRemove = tokens.get(left);
            if (wordsSet.contains(tokenToRemove)) {
              windowFrequencyMap.put(tokenToRemove, windowFrequencyMap.get(tokenToRemove) - 1);
            }
            left++;

            // add right
            String tokenToAdd = tokens.get(right);
            if (wordsSet.contains(tokenToAdd)) {
              windowFrequencyMap.put(tokenToAdd, windowFrequencyMap.getOrDefault(tokenToAdd, 0) + 1);
            }
            right++;
          } else {
            break;
          }
        }
        if (isEqualFrequencyMaps(windowFrequencyMap, originalFrequencyMap)) {
          goodIndexes.add(startingIndex + left * wordLength);
        }
      }
    }

    return goodIndexes;
  }

  boolean isEqualFrequencyMaps(Map<String, Integer> f1, Map<String, Integer> f2) {
    return f1.equals(f2);
  }

  List<String> splitToTokens(String s, int startingIndex, int tokenLength) {
    List<String> result = new ArrayList<>();
    int idx = startingIndex;
    StringBuilder currentWord = new StringBuilder();
    while (idx < s.length()) {
      if (currentWord.length() < tokenLength) {
        currentWord.append(s.charAt(idx));
      } else {
        result.add(currentWord.toString());
        currentWord = new StringBuilder();
        currentWord.append(s.charAt(idx));
      }
      idx++;
    }
    if (currentWord.length() == tokenLength) {
      result.add(currentWord.toString());
    }
    return result;
  }

}
