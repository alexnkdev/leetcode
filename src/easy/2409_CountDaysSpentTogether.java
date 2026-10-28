class Solution {
  
  public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
    
    int[] days = new int[366];

    int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    
    int currentMonth = 0;
    int monthDay = 1;
    
    boolean aliceIn = false;
    boolean bobIn = false;

    for (int currentDay = 1; currentDay <= 365; currentDay++) {
      
      String f = format(currentMonth + 1, monthDay);
    
      if (f.equals(arriveAlice)) {
        aliceIn = true;
      }
      
      if (f.equals(arriveBob)) {
        bobIn = true;
      }
  

      if (aliceIn) {
        days[currentDay]++;
      }

      if (bobIn) {
        days[currentDay]++;
      }
      

      if (monthDay == months[currentMonth]) {
        currentMonth++;
        monthDay = 1;
      } else {
        monthDay++;
      }

          if (f.equals(leaveAlice)) {
        aliceIn = false;
      }
      if (f.equals(leaveBob)) {
        bobIn = false;
      }

    }


    int ret = 0;
    for (int i = 0; i <= 365; i++) {
      if (days[i] == 2) {
        ret++;
      }
    }

    return ret;

  }

  String format(int month, int monthDay ) {
    String strMonth = "" + month;
    String strMonthDay = "" + monthDay;
    if (strMonth.length() < 2) {
      strMonth = "0" + strMonth;
    }
    if (strMonthDay.length() < 2) {
      strMonthDay = "0" + strMonthDay;
    }
    return strMonth + "-" + strMonthDay;
  }

}
