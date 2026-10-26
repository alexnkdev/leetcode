class Solution {
  public int peakValleyDifference(int[] nums) {
    int sumPeaks = 0;
    int sumValleys = 0;
    for (int i = 0; i < n; i++) {
      boolean isPeak = i > 0 && i < n - 1
        && nums[i] > nums[i - 1]
        && nums[i] > nums[i + 1];
      boolean isValley = i > 0 && i < n - 1
        && nums[i] < nums[i - 1]
        && nums[i] < nums[i + 1];
      if (isPeak) {
        sumPeaks++;
      }
      if (isValley) {
        sumValleys++;
      }
    }
    return sumPeaks - sumValleys;
  }
}
