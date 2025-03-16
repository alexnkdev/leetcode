class Solution {
  public long repairCars(int[] ranks, int cars) {
    Arrays.sort(ranks);
    int min_rank = ranks[0];
    long low = 0;
    long high = (long) min_rank * (long) cars * cars;
    long last = 0L;
    while (low <= high) {
      long mid = low + (high - low) / 2;
      if (is_possible(mid, ranks, cars)) {
        last = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return last;
  }

  boolean is_possible(long minutes, int[] ranks, int cars) {
    long cars_left = cars;
    for (int i = 0; i < ranks.length; i++) {
      long can_take_cars = (long) Math.floor(Math.sqrt(minutes/ranks[i]));
      cars_left -= Math.min(can_take_cars, cars_left);
    }
    return cars_left == 0;
  }
}
