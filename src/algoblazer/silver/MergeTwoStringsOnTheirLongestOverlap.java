class Solution {
  public String mergeOnOverlap(String first, String second) {

    int o1 = try_overlap(first, second);
    int o2 = try_overlap(second, first);

    System.out.println(o1 + " " + o2);
    return "44";
  }

  String try_overlap(String a, String b) {
    Set<String> suffixes = new HashSet<>();
    StringBuilder suffix = new StringBuilder();
    for (int len = 1; len <= a.length(); len++) {
      suffix.append(a.charAt(a.length() - len));
      suffixes.add(suffix.toString());
    }

    StringBuilder prefix = new StringBuilder();
    String longest = null;
    for (int len = 1; len <= b.length(); len++) {
      prefix.append(b.charAt(len - 1));
      if (suffixes.contains(prefix)) {
        longest = prefix;
      }
    }
    return longest;
  }
}
