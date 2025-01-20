package algorithms;

import java.util.ArrayList;
import java.util.List;

public class P729_MyCalendar {

    private List<Event> events = new ArrayList<>();
    
    boolean canBook(int start, int end) {
        for (Event e : events) {
            if (start >= e.start && start < e.end) {
                return false;
            }
            if (end > e.start && end < e.end) {
                return false;
            }
            if (start <= e.start && end >= e.end) {
                return false;
            }
        }    
        return true;
    }
    
    public boolean book(int start, int end) {
        if (canBook(start, end)) {
            events.add(new Event(start, end));
            return true;
        } else {
            return false;
        }
    }
    
    class Event {
        int start;
        int end;
        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
