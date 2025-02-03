class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> nextRow = new ArrayList<>();
            List<Integer> prevRow = ret.get(i - 1);
            nextRow.add(1);
            for (int j = 0; j < prevRow.size() - 1; j++) {
                nextRow.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            nextRow.add(1);
            ret.add(nextRow);
        }
        return ret;
    }
}