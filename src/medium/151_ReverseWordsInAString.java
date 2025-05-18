class Solution {
  public String reverseWords(String s) {
    int i = 0;
    StringBuilder currentWord = new StringBuilder();
    List<String> words = new ArrayList<>();
    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == ' ') {
        if (currentWord.length() > 0) {
          words.add(currentWord.toString());
          currentWord = new StringBuilder();
        }
      } else {
        currentWord.append(c);
      }
      i++;
    }
    if (currentWord.length() > 0) {
      words.add(currentWord.toString());
    }
    Collections.reverse(words);
    return String.join(" ", words);
  }
}
