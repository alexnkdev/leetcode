class Solution {

  boolean[] used;

  public String[] distinctPermutations(String s) {
    used = new boolean[s.length()];
    Set<String> perms = generate(s, 0);

    String[] ret = new String[perms.size()];
    int cc = 0;
    for (String sss : perms) {
      ret[cc++] = sss;
    }
    Arrays.sort(ret);
    return ret;
  }

  Set<String> generate(String s, int step) {
    if (step == s.length()) {
      Set<String> ret = new HashSet<>();
      ret.add("");
      return ret;
    }

    Set<String> ret = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (!used[i]) {
        used[i] = true;

        Set<String> sub = generate(s, step + 1);
        
        for (String ss: sub) {
          String newStr = s.charAt(i) + ss;
          ret.add(newStr);
        }

        used[i] = false;
      }
    }

    return ret;
  }
}
