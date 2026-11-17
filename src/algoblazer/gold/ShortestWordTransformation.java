class Solution {
  public int shortestTransformation(String beginWord, String endWord, String[] wordList) {

    List<String> words = new ArrayList<>();
    words.add(beginWord);
    for (int i = 0; i < wordList.length; i++) {
      words.add(wordList[i]);
    }

    int s = 0;
    int t = words.indexOf(endWord);
    if (t < 0) {
      return 0;
    }

    Queue<Integer> q = new LinkedList<>();
    q.add(s);

    int n = words.size();
    boolean[] visited = new boolean[n];
    int[] d = new int[n];
    d[0] = 1;

    boolean[][] a = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int k = i + 1; k < n; k++) {
       
        int diff = 0;
        for (int kk = 0; kk < words.get(i).length(); kk++) {
          char c1 = words.get(i).charAt(kk);
          char c2 = words.get(k).charAt(kk);
          if (c1 != c2) {
            diff++;
          }
        }

        if (diff == 1) {
          a[i][k] = true;
          a[k][i] = true;
        }
      }
    }

    while (!q.isEmpty()) {
      int current = q.poll();
      visited[current] = true;
      for (int i = 0; i < n; i++) {
        if (a[current][i]) {
          if (!visited[i]) {
            visited[i] = true;
            q.add(i);
            d[i] = d[current] + 1;
          }
        }
      }
    }

    if (!visited[t]) {
      return 0;
    }

    return d[t];

  }
}
