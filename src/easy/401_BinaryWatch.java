class Solution {
  public List<String> readBinaryWatch(int turnedOn) {
    int n = 10;
    int[] hours = new int[] { 8, 4, 2, 1 };
    int[] minutes = new int[] { 32, 16, 8, 4, 2, 1 };
    List<String> ret = new ArrayList<>();
    for (int set = 0; set < (1 << n); set++) {
      int cnt_set = 0;
      for (int k = 0; k < n; k++) {
        if ((set & (1 << k)) != 0) {
          cnt_set++;
        }
      }
      if (cnt_set == turnedOn) {
        int total_hours = 0;
        int total_minutes = 0;
        for (int k = 0; k < n; k++) {
          if ((set & (1 << k)) != 0) {
            if (k < minutes.length) {
              total_minutes += minutes[k];
            } else {
              total_hours += hours[k - minutes.length];
            }
          }
        }
        if (total_hours <= 11 && total_minutes <= 59) {
          ret.add(format(total_hours, total_minutes));
        }
      }
    }
    return ret;
  }

  String format(int h, int m) {
    String hoursStr = "" + h;
    String minutesStr = "" + m;
    while (minutesStr.length() < 2) {
      minutesStr = "0" + minutesStr;
    }
    return hoursStr + ":" + minutesStr;
  }
}
