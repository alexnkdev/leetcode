class Solution {
  public int[][] anagramIndexGroups(String[] w) {

    boolean[][] isAnagrams = new boolean[w.length][w.length];
    int[][] freq = new int[w.length][26];
    for (int i = 0; i < w.length; i++) {
      for (int j = 0; j < w[i].length(); j++) {
        char c = w[i].charAt(j);
        freq[i][(int)(c - 'a')]++;
      }
    }

    for (int i = 0; i < w.length; i++) {
      for (int j = i + 1; j < w.length; j++) {
        boolean good = true;
        for (int k = 0; k < 26; k++) {
          if (freq[i][k] != freq[j][k]) {
            good = false;
            break;
          }
        }
        if (good) {
          isAnagrams[i][j] = true;
          isAnagrams[j][i] = true;
        }
      }
    }


    Map<Integer, TreeSet<Integer>> groups = new TreeMap<>();
    for (int i = 0; i < w.length; i++) {
      String word = w[i]; 
      Integer groupIndex = null;

      for (Integer gIndex : groups.keySet()) {
        if (isAnagrams[gIndex][i]) {
          groupIndex = gIndex;
          break;
        }
      }

      if (groupIndex == null) {
        TreeSet<Integer> newList = new TreeSet<>();
        newList.add(i);
        groups.put(i, newList);
      } else {
        groups.get(groupIndex).add(i);
      }
    }

    int[][] ret = new int[groups.keySet().size()][];
    int group = 0;
    for (Integer key : groups.keySet()) {
      TreeSet<Integer> anagrams = groups.get(key);
      ret[group] = new int[anagrams.size()];
      int pos = 0;
      for (Integer idx : anagrams) {
        ret[group][pos++] = idx;
      }
      group++;
    }
    return ret;
  }


}
