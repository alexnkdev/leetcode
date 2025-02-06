class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Set<List<Integer>>> tuplesByProduct = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                int product = nums[i] * nums[j];
                List<Integer> p = new ArrayList<>();
                p.add(nums[i]);
                p.add(nums[j]);
                Collections.sort(p);
                Set<List<Integer>> tuples =  tuplesByProduct.getOrDefault(product, new HashSet<>());
                tuples.add(p);
                tuplesByProduct.put(product, tuples);
            }
        }
        int ret = 0;
        for (Integer p : tuplesByProduct.keySet()) {
            int num = tuplesByProduct.get(p).size();
            int quadruples = num * (num - 1) / 2;
            ret += (quadruples * 2 + quadruples * 2) * 2;
        }
        return ret;
    }
}