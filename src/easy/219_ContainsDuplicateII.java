import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        LinkedList<Integer> window = new LinkedList<>();
        Set<Integer> windowSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (windowSet.contains(nums[i])) {
                return true;
            }
            windowSet.add(nums[i]);
            window.addLast(nums[i]);
            if (window.size() > k) {
                int first = window.removeFirst();
                windowSet.remove(first);
            }
        }
        return false;
    }
}