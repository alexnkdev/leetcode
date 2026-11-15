class Solution {
  public int[] ticketCheckRoute(int[][] chart, int rowsToCheck) {
    int[] rowPeople = new int[chart.length];
    for (int i = 0; i < chart.length; i++) {
      int people = 0;
      for (int j = 0; j < chart[i].length; j++) {
        if (chart[i][j] == 1) {
          people++;
        }
      }
      rowPeople[i] = people;
    }
    List<Integer> idxs = new ArrayList<>();
    for (int i = 0; i < chart.length; i++) {
      idxs.add(i);
    }
    Collections.sort(idxs, (idx1, idx2) -> {
      int p1 = rowPeople[idx1];
      int p2 = rowPeople[idx2];
      if (p1 < p2) {
        return -1;
      } else if (p1 > p2) {
        return 1;
      } else {
        return Integer.compare(idx1, idx2);
      }
    });

    int[] ret = new int[rowsToCheck];
    for (int i = 0; i < rowsToCheck; i++) {
      ret[i] = idxs.get(i);
    }
    return ret;
  }

}
