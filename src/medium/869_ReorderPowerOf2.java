class Solution {
  public boolean reorderedPowerOf2(int n) {
    List<String> powers2 = new ArrayList<>();
    long current = 1L;
    for (int i = 0; i <= 33; i++) {
      powers2.add("" + current);
      current = current * 2;
    }
    for (String power2 : powers2) {
      char[] power2ch = power2.toCharArray();
      char[] n2ch = ("" + n).toCharArray();
      Arrays.sort(power2ch);
      Arrays.sort(n2ch);
      if (Arrays.equals(power2ch, n2ch)) {
        return true;
      }
    }
    return false;
  }
}
