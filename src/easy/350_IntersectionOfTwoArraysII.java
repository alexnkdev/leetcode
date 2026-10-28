class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    int[] freq1 = new int[1001];
    int[] freq2 = new int[1001];
    for (int i = 0; i < nums1.length; i++) {
      freq1[nums1[i]]++;
    }
    for (int i = 0; i < nums2.length; i++) {
      freq2[nums2[i]]++;
    }
    List<Integer> ret = new ArrayList<>();
    for (int i = 0; i < 1001; i++) {
      int min = Math.min(freq1[i], freq2[i]);
      for (int j = 0; j < min; j++) {
        ret.add(i);
      }
    }
    int[] retarr = new int[ret.size()];
    for (int i = 0; i < ret.size(); i++) {
      retarr[i] = ret.get(i);
    }
    return retarr;
  }
}
