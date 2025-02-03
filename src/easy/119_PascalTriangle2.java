class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        List<Integer> prevRow = List.of(1);
        for (int currentRowIndex = 1; currentRowIndex <= rowIndex; currentRowIndex++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 0; j < prevRow.size() - 1; j++) {
                currentRow.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            currentRow.add(1);
            prevRow = currentRow;
        }
        return prevRow;
    }
}