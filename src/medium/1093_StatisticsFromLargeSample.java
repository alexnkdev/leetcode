class Solution {
  public double[] sampleStats(int[] counts) {
    Integer minimum = null;
    Integer maximum = null;
    Double mean = null; 
    Double median = null;
    Integer mode = null;
    Double total_sum = 0.0;
    int total_elements = 0;
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 0) {
        if (minimum == null || i < minimum) {
          minimum = i;
        }
        if (maximum == null || i > maximum) {
          maximum = i;
        }
        if (mode == null || counts[i] > counts[mode]) {
          mode = i;
        }
      }
      total_sum += 1.0 * counts[i] * i;
      total_elements += counts[i];
    }
    mean = total_sum / total_elements;
    if (total_elements % 2 == 1) {
      median = 1.0 * findElementAtPos(total_elements / 2, counts);
    } else {
      median = (findElementAtPos(total_elements / 2 - 1, counts) +
        findElementAtPos(total_elements / 2, counts)) / 2.0;
    }
    return new double[] { minimum, maximum, mean, median, mode };
  }

  public Integer findElementAtPos(int pos, int[] counts) {
    int elementsSoFar = 0;
    int i = 0;
    while (true) {
      if (elementsSoFar + counts[i] <= pos) {
        elementsSoFar += counts[i];
        i++;
      } else {
        return i;
      }
    }
  }
}
