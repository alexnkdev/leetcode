class Solution {
  public String[] mostIndebted(String[] b, String[] l, int[] am) {
    Map<String, Long> balance = new HashMap<>();

    for (int i = 0; i < b.length; i++) {
      long amount = am[i];

      balance.put(b[i], balance.getOrDefault(b[i], 0L) - amount);
      balance.put(l[i], balance.getOrDefault(l[i], 0L) + amount);
    }



    String smallest = null;
    for (String person : balance.keySet()) {
      if (smallest == null || balance.get(person) < balance.get(smallest)) {
        smallest = person;
      } 
    }
    List<String> ret = new ArrayList<>();
    for (String person : balance.keySet()) {
      if (balance.get(person).equals(balance.get(smallest))) {
        ret.add(person);
      }
    }
    Collections.sort(ret);
    String[] ret_arr = new String[ret.size()];
    for (int i = 0; i < ret.size(); i++) {
      ret_arr[i] = ret.get(i);
    }
    return ret_arr;
  }
}
