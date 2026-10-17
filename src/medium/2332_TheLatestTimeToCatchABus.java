class Solution {

  int P = 0;
  int B = 1;

  public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
    List<Event> events = new ArrayList<>();
    for (int i = 0; i < passengers.length; i++) {
      events.add(new Event(passengers[i], P));
    }
    for (int i = 0; i < buses.length; i++) {
      events.add(new Event(buses[i], B));
    }
    Collections.sort(events, (e1, e2) -> {
      if (e1.time < e2.time) {
        return -1;
      }
      if (e1.time > e2.time) {
        return 1;
      }
      if (e1.type == P) {
        return -1;
      }
      if (e1.type == B) {
        return 1;
      }
      return 0;
    });
    return latestTime(events, capacity);
  }


  int latestTime(List<Event> events, int capacity) {
    Queue<Integer> q = new LinkedList<>();
    int best = 1;
    int prev = -1;
    for (Event event : events) {
      if (event.type == P) {
        q.add(event.time);
      } else {
        int capacityRem = capacity;
        while (capacityRem > 0 && !q.isEmpty()) {
            int next = q.peek();
            if (prev == -1 || next > prev + 1) {
                best = next - 1;
            }            
            prev = q.poll();
            capacityRem--;
        }
        if (capacityRem > 0 && prev < event.time) {
            best = event.time;
        }
      }
    }
    return best;
  }

  class Event {
    int time;
    int type;
    public Event(int time, int type) {
      this.time = time;
      this.type = type;
    }

    public String toString() {
        return "(" + time + " - " + type + ")";
    }
  }

}
