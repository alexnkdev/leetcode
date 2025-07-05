class Solution {
  public char kthCharacter(long k, int[] operations) {
    return findKthCharacter(k, operations);
  }

  public char findKthCharacter(long k, int[] operations) {
    if (k == 1) {
      return 'a';
    }
    int operationIndex = findCurrentOperationIndex(k) - 1;
    long segmentLength = 1L << (operationIndex);
    int operationType = operations[operationIndex];
    if (operationType == 0) {
      long prev = k - segmentLength;
      return findKthCharacter(prev, operations);
    } else {
      long prev = k - segmentLength;
      char prev_char = findKthCharacter(prev, operations);
      char current_char = (char) (((int) (prev_char - 'a') + 1) % 26 + 'a');
      return current_char;
    }
  }

  public int findCurrentOperationIndex(long k) {
    if (k <= 1) {
      return 0;
    }
    k--;
    int cnt = 0;
    while (k != 0) {
      k /= 2;
      cnt++;
    }
    return cnt;
  }
}
