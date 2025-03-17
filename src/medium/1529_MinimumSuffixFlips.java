class Solution {
  public int minFlips(String target) {
    int numFlips = 0;
    for (int i = 0; i < target.length(); i++) {
      char c = target.charAt(i);
      char current = numFlips % 2 == 0 ? '0' : '1';
      if (current != c) {
        numFlips++;
      }
    }
    return numFlips;
  }
}
