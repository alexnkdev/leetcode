class Solution {
  public String[] crewsWithLowestScore(
      String[] takers,
      String[] givers,
      int[] litres
      ) {
    Map<String, Long> scores = new HashMap<>();
    Set<String> crews = new HashSet<>();
    for (int i = 0; i < takers.length; i++) {
      crews.add(takers[i]);
    }
    for (int i = 0; i < givers.length; i++) {
      crews.add(givers[i]);
    }
    for (String crew : crews) {
      scores.put(crew, 0L);
    }
    int n = litres.length;
    for (int i = 0; i < n; i++) {
      String toCrew = takers[i];
      String fromCrew = givers[i];
      long l = litres[i];
      scores.put(toCrew, scores.get(toCrew) - l);
      scores.put(fromCrew, scores.get(fromCrew) + l);
    }
    Long lowestScore = null;
    for (String crew : crews) {
      if (lowestScore == null || lowestScore > scores.get(crew)) {
        lowestScore = scores.get(crew);
      }
    }
    List<String> ret = new ArrayList<>();
    for (String crew : crews) {
      if (scores.get(crew).equals(lowestScore)) {
        ret.add(crew);
      }
    }
    String[] ret_arr = new String[ret.size()];
    for (int i = 0; i < ret.size(); i++) {
      ret_arr[i] = ret.get(i);
    }
    Arrays.sort(ret_arr);
    return ret_arr;
      }
}
