class Solution {

    static int START = 0;
    static int END = 1;

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            events.add(new Event(START, intervals[i][0]));
            events.add(new Event(END, intervals[i][1]));
        }
        events.add(new Event(START, newInterval[0]));
        events.add(new Event(END, newInterval[1]));

        Collections.sort(events, new Comparator<>() {
            public int compare(Event e1, Event e2) {
                if (e1.x < e2.x) {
                    return -1;
                }
                if (e1.x > e2.x) {
                    return 1;
                }
                if (e1.eventType == e2.eventType) {
                    return 0;
                }
                if (e1.eventType == START) {
                    return -1;
                }
                if (e1.eventType == END) {
                    return 1;
                }
                return 0;
            }
        });
        
        Integer current_interval_start = null;
        int depth = 0;

        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for (Event e : events) {
            if (e.eventType == START) {
                if (current_interval_start == null) {
                    current_interval_start = e.x;
                }
                depth++;
            } else {
                depth--;
                if (depth == 0) {
                    starts.add(current_interval_start);
                    ends.add(e.x);
                    current_interval_start = null;
                }
            }
        }

        int[][] ret = new int[starts.size()][2];
        for (int i = 0; i < starts.size(); i++) {
            ret[i][0] = starts.get(i);
            ret[i][1] = ends.get(i);
        }

        return ret;
    }

    class Event {
        int eventType;
        int x;

        public Event(int eventType, int x) {
            this.eventType = eventType;
            this.x = x;
        }
    }
}