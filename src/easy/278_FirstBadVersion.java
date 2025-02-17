/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int from = 1;
            int to = n;
            while (from <= to) {
                int mid = from + (to - from) / 2;
                if (isBadVersion(mid)) {
                    to = mid - 1;
                } else {
                    from = mid + 1;
                }
            }
            return to + 1;
        }
    }