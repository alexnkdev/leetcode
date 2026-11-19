class Solution {
  public int maxNonOverlapping(int[][] intervals) {
    List<Int> ints = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      ints.add(new Int(intervals[i][0], intervals[i][1]));
    }
    Collections.sort(ints, (i1, i2) -> {
      return Integer.compare(i1.to, i2.to);
    });

    Int current = null;
    int ret = 0;
    for (Int interval : ints) {
      if (current == null || (interval.from >= current.to)) {
        current = interval;
        ret++;
      }
    }

    return ret;
  }

  class Int {
    public int from, to;
    public Int(int from, int to) {
      this.from = from;
      this.to = to;
    }
  }
}
