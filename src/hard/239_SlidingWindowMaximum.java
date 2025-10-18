
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeSet<Key> set = new TreeSet<>(((k1, k2) -> {
            if (k1.key < k2.key) {
                return 1;
            } else if (k1.key > k2.key) {
                return -1;
            } else {
                return Integer.compare(k1.index, k2.index);
            }
        }));
        int left = 0;
        for (int i = 0; i < k; i++) {
            set.add(new Key(nums[i], i));
        }
        List<Integer> ret = new ArrayList<>();
        ret.add(set.iterator().next().key);
        for (int i = k; i < nums.length; i++) {
            set.remove(new Key(nums[i - k], i - k));
            set.add(new Key(nums[i], i));
            ret.add(set.iterator().next().key);
            
        }
        int[] arr = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            arr[i] = ret.get(i);
        }
        return arr;
    }


    static class Key {
        int key;
        int index;
        public Key(int key, int index) {
            this.key = key;
            this.index = index;
        }

        public String toString() {
            return "" + key;
        }

        public boolean equals(Key other) {
            return other.key == key && other.index == index;
        }
    }

}
