class Solution {
  public String minimizeStringValue(String s) {
    
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != '?') {
            freq[s.charAt(i) - 'a']++;
        }
    }
    List<Character> sub = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '?') {
        int min = 0;
        for (int k = 1; k < 26; k++) {
          if (freq[k] < freq[min]) {
            min = k;
          }
        }
        sub.add((char)('a' + min));
        freq[min]++;
      }
    }
    Collections.sort(sub);
    int idx = 0;
    StringBuilder ret = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '?') {
            ret.append(sub.get(idx++));
        } else {
            ret.append(s.charAt(i));
        }
    }
    return ret.toString();
  }
}
