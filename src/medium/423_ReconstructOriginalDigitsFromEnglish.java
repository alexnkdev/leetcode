
class Solution {
  public String originalDigits(String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
      freq[c - 'a']++;
    }

    int[] cnt = new int[10];
    cnt[0] = freq[(int) ('z' - 'a')];
    cnt[2] = freq[(int) ('w' - 'a')];
    cnt[4] = freq[(int) ('u' - 'a')];
    cnt[6] = freq[(int) ('x' - 'a')];
    cnt[5] = freq[(int) ('f' - 'a')] - cnt[4];
    cnt[7] = freq[(int) ('s' - 'a')] - cnt[6];
    cnt[1] = freq[(int) ('o' - 'a')] - cnt[4] - cnt[0] - cnt[2];

    cnt[3] = freq[(int) ('r' - 'a')] - cnt[4] - cnt[0];
    cnt[8] = freq[(int) ('t' - 'a')] - cnt[2] - cnt[3];
    cnt[9] = freq[(int) ('i' - 'a')] - cnt[5] - cnt[6] - cnt[8];

    StringBuilder ret = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < cnt[i]; j++) {
        ret.append((char) ('0' + i));
      }
    }
    return ret.toString();

  }
}
