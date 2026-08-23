class Solution {

    public int longestSubarray(int[] nums, int k) {
        int left = 0;
        Map<Integer, Integer> windowFactors = new HashMap<>();
        int ret = 0;
        for (int right = 0; right < nums.length; right++) {
            List<Integer> factors = factorize(nums[right]);
            for (Integer factor : factors) {
                if (windowFactors.get(factor) == null) {
                    windowFactors.put(factor, 1);
                } else {
                    windowFactors.put(factor, windowFactors.get(factor) + 1);
                }
            }
            if (windowFactors.keySet().size() > k) {
                List<Integer> leftFactors = factorize(nums[left]);
                for (Integer factor : leftFactors) {
                    windowFactors.put(factor, windowFactors.get(factor) - 1);
                    if (windowFactors.get(factor) == 0) {
                        windowFactors.remove(factor);
                    }
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }

    List<Integer> factorize(int number) {
        List<Integer> primes = new ArrayList<>();
        int n = number;
        while (n % 2 == 0) {
            primes.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primes.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            primes.add(n);
        }
        return primes;
    }
}
