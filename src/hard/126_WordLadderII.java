
import java.util.Queue;

class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return new ArrayList<>();
    }
    Map<String, Set<String>> adj = new HashMap<>();
    List<String> all = new ArrayList<>();
    all.add(beginWord);
    all.add(endWord);
    all.addAll(wordList);
    for (String w : all) {
      adj.put(w, new HashSet<>());
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
    Map<String, List<String>> prev = new HashMap<>();
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
          if (prev.get(other) == null) {
            prev.put(other, new ArrayList<>());
          }
          prev.get(other).add(current);
          q.add(other);
        } else if (visited.contains(other) && dist.get(other) == dist.get(current) + 1) {
          prev.get(other).add(current);
        }
      }
    }
    if (!dist.containsKey(endWord)) {
      return new ArrayList<>();
    }
    System.out.println(prev);
    List<List<String>> paths = reconstructPaths(endWord, prev);
    return paths;
  }

  List<List<String>> reconstructPaths(String current, Map<String, List<String>> prev) {
    if (prev.get(current) == null) {
      List<List<String>> ret = new ArrayList<>();
      List<String> path = new ArrayList<>();
      path.add(current);
      ret.add(path);
      return ret;
    }
    List<List<String>> ret = new ArrayList<>();
    for (String p : prev.get(current)) {
      List<List<String>> subPaths = reconstructPaths(p, prev);
      for (List<String> subPath : subPaths) {
        List<String> newPath = new ArrayList<>();
        newPath.addAll(subPath);
        newPath.add(current);
        ret.add(newPath);
      }
    }
    return ret;
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
