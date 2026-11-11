class Solution {
  
  public int[] topKByFrequency(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(
        new Comparator<Integer>() {
          public int compare(Integer first, Integer second) {
            if (freq.get(first) > freq.get(second)) {
              return -1;
            }
            if (freq.get(first) < freq.get(second)) {
              return 1;
            }
            return -Integer.compare(first, second);
          }
        }
    );

    Set<Integer> ss = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      ss.add(nums[i]);
    }
    for (Integer s : ss) {
      pq.add(s);
    } 
    int[] ret = new int[k];
    int cc = 0;
    while (cc < k) {
      ret[cc++] = pq.poll();
    }
    return ret;

  }

}
