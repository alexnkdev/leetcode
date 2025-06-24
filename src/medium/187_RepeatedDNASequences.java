import java.util.Map;

class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    Map<String, Integer> freq = new HashMap<>();
    StringBuilder current = new StringBuilder();
    if (s.length() < 10) {
      return Collections.emptyList();
    }
    int idx = 0;
    while (idx < 10) {
      current.append(s.charAt(idx++));
    }
    freq.put(current.toString(), 1);
    while (idx < s.length()) {
      current.deleteCharAt(0);
      current.append(s.charAt(idx));
      freq.put(current.toString(), freq.getOrDefault(current.toString(), 0) + 1);
      idx++;
    }
    List<String> ret = new ArrayList<>();
    for (String str : freq.keySet()) {
      if (freq.get(str) > 1) {
        ret.add(str);
      }
    }
    return ret;
  }
}
