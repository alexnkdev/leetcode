import java.util.Queue;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return 0;
    }
    Map<String, List<String>> adj = new HashMap<>();
    List<String> all = new ArrayList<>();
    all.add(beginWord);
    all.add(endWord);
    all.addAll(wordList);
    for (String w : all) {
      adj.put(w, new ArrayList<>());
    }
    for (String w1 : all) {
      for (String w2 : all) {
        if (isConnected(w1, w2)) {
          adj.get(w1).add(w2);
          adj.get(w2).add(w1);
        }
      }
    }
    Map<String, Integer> dist = new HashMap<>();
    Set<String> visited = new HashSet<>();
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    dist.put(beginWord, 1);
    visited.add(beginWord);
    while (!q.isEmpty()) {
      String current = q.poll();
      for (String other : adj.get(current)) {
        if (!visited.contains(other)) {
          visited.add(other);
          dist.put(other, dist.get(current) + 1);
          q.add(other);
        }
      }
    }
    return dist.containsKey(endWord) ? dist.get(endWord) : 0;
  }

  boolean isConnected(String w1, String w2) {
    int diffs = 0;
    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) != w2.charAt(i)) {
        diffs++;
      }
    }
    return diffs == 1;
  }
}
