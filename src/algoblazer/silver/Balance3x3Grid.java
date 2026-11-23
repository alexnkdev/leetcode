class Solution {

  int n = 3;
  int m = 3;

  int[] di = new int[] { 0, 0, 1, -1 };
  int[] dj = new int[] { 1, -1, 0, 0 };

  Set<List<List<Integer>>> visited = new HashSet<>();
  Map<List<List<Integer>>, Integer> dist = new HashMap<>();

  public int balanceThreeByThreeGrid(int[][] g) {

    List<List<Integer>> grid = new ArrayList<>();
    for (int i = 0; i < g.length; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < g[0].length; j++) {
        row.add(g[i][j]);
      }
      grid.add(row);
    }

    Queue<List<List<Integer>>> q = new LinkedList<>();
    q.add(grid);
    dist.put(grid, 0);

    List<List<Integer>> endGrid = null;

    while (!q.isEmpty()) {
      List<List<Integer>> current = q.poll();
      markVisited(current);
      if (isEndGrid(current)) {
        endGrid = current;
        break;
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (current.get(i).get(j) > 0) {
             
            for (int k = 0; k < 4; k++) {
             int ni = i + di[k];
             int nj = j + dj[k];
             if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
               List<List<Integer>> copy = copyGrid(current);
               copy.get(ni).set(nj, copy.get(ni).get(nj) + 1);
               copy.get(i).set(j, copy.get(i).get(j) - 1);
               if (!isVisited(copy)) {
                  markVisited(copy);
                  dist.put(copy, dist.get(current) + 1);
                  q.add(copy);
               }

             }
            }
          }
        }
      }
    }

    return dist.get(endGrid);
  }

  List<List<Integer>> copyGrid(List<List<Integer>> grid) {
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < m; j++) {
        row.add(grid.get(i).get(j));
      }
      ret.add(row);
    }
    return ret;
  }
  
  boolean isEndGrid(List<List<Integer>> grid) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid.get(i).get(j) != 1) {
          return false;
        }
      }
    }
    return true;
  }

  boolean isVisited(List<List<Integer>> grid) {
    return visited.contains(grid);
  }

  void markVisited(List<List<Integer>> grid) {
    visited.add(grid);
  }
}


