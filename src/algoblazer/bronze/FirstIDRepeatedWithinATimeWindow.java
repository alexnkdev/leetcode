class Solution {
  public String firstRepeatWithinWindow(String[] ids, int[] timestamps) {
    Map<String, Integer> lastSeen = new HashMap<>();
    for (int i = 0; i < ids.length; i++) {
      String current = ids[i];
      if (lastSeen.containsKey(current)) {
        int lastTimestamp = lastSeen.get(current);
        if (timestamps[i] - lastTimestamp <= 10) {
          return current;
        }
      }
      lastSeen.put(current, timestamps[i]);
    }
    return "NONE";
  }
}
