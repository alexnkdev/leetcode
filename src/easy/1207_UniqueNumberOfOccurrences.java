class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }    
        int nkeys = freq.keySet().size();
        Set<Integer> valuesSet = new HashSet<>();
        for (Integer key : freq.keySet()) {
            valuesSet.add(freq.get(key));
        }
        return nkeys == valuesSet.size();
    }
}