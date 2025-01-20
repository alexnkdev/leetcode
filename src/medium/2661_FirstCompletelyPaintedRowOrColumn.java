import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        int[] row_counts = new int[rows];
        int[] column_counts = new int[columns];
        Map<Integer, List<Integer>> cells = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells.put(mat[i][j], Arrays.asList(i, j));
            }
        }
        for (int i = 0; i < arr.length; i++) {
            
            for (int k = 0; k < rows; k++) {
                if (row_counts[k] == columns) {
                    return i;
                }
            }
            for (int k = 0; k < columns; k++) {
                if (column_counts[k] == rows) {
                    return i;
                }
            }
        }
        return 0;
    }
}