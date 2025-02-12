class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> max = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = sumDigits(nums[i]);
            if (max.get(sum) == null) {
                max.put(sum, new ArrayList<>());
            }
            List<Integer> maxes = max.get(sum);
            maxes.add(nums[i]);
            Collections.sort(maxes);
            Collections.reverse(maxes);
            if (maxes.size() > 2) {
                maxes = maxes.subList(0, 2);
                max.put(sum, maxes);
            }
        }
        int ret = -1;
        for (Integer s : max.keySet()) {
            if (max.get(s).size() > 1) {
                Iterator<Integer> iter = max.get(s).iterator();
                Integer first = iter.next();
                Integer second = iter.next();
                ret = Math.max(ret, first + second);
            }
        }
        return ret;
    }

    int sumDigits(int x) {
        int ret = 0;
        while (x != 0) {
            ret += x % 10;
            x /= 10;
        }
        return ret;
    }
}