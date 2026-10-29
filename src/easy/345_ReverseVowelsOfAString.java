class Solution {
  public String reverseVowels(String s) {
    List<Character> vowels = new ArrayList<>();
    for (char c : s.toCharArray()) {
      if (isVowel(c)) {
        vowels.add(c);
      }
    }
    Collections.reverse(vowels);
    StringBuilder ret = new StringBuilder();
    int idx = 0;
    for (int i = 0; i < s.length(); i++) {
      if (isVowel(s.charAt(i))) {
        ret.append(vowels.get(idx++));
      } else {
        ret.append(s.charAt(i));
      }
    }
    return ret.toString();
  }

  boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
      || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
  }
}
