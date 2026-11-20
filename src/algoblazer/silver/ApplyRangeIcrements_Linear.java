class Solution {
  public int[] applyRangeIncrements(int[] nums, int[][] operations) {

    int n = nums.length;

    int num = 1;
    int open = 0;
    int close = 2;

    List<Event> events = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      events.add(new Event(num, i, -1));    
    }

    for (int i = 0; i < operations.length; i++) {
      events.add(new Event(open, operations[i][0], operations[i][2]));
      events.add(new Event(close, operations[i][1], -operations[i][2]));
    }

    Collections.sort(events, (e1, e2) -> {
      if (e1.idx != e2.idx) {
        return Integer.compare(e1.idx, e2.idx);
      } else {
        return Integer.compare(e1.type, e2.type);
      }
    });

    int add = 0;

    for (Event e : events) {
      if (e.type == num) {
        nums[e.idx] += add;
      } else {
        add += e.diff;
      }
    }

    return nums;

  }

  class Event {
    int type;
    int idx;
    int diff;

    public Event(int type, int idx, int diff) {
      this.type = type;
      this.idx = idx;
      this.diff = diff;
    }
  }
}
