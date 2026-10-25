class Solution {

  public int lenLongestFibSubseq(int[] arr) {
    
    int ret = 0;
    
    for (int i = 0; i < arr.length; i++) {
      
      for (int j = i + 1; j < arr.length; j++) {
        
        int prevprev = arr[i];
        int prev = arr[j];
        int len = 2;
        for (int k = j + 1; k < arr.length; k++) {
          if (arr[k] == prev + prevprev) {
            len++;
            prevprev = prev;
            prev = arr[k];
          } else if (arr[k] > prev + prevprev) {
            break;
          }
        }

        if (len > 2) {
          ret = Math.max(ret, len);
        }
      }

    }

    return ret;

  }

}
