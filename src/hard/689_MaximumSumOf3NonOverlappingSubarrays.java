class Solution {
  
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    
    int n = nums.length;
    int[] prefixSums = new int[n + 1];
    int subarrays = 3;

    prefixSums[0] = 0;
    for (int i = 1; i <= n; i++) {
      prefixSums[i] = nums[i - 1] + prefixSums[i - 1];
    }

    int[][] dp = new int[n + 1][subarrays + 1];
    int[][] prev = new int[n + 1][subarrays + 1];

    dp[0][0] = 0;
    prev[0][0] = -1;

    int take_subarray = 1;
    int skip = 2;

    for (int i = 1; i <= n; i++) {
      
      for (int kk = 1; kk <= subarrays; kk++) {
        int a = nums[i - 1];
      
        // 1. start new subarray [i - k, i)
        
        if (i - k >= 0) {
          int subarraySum = prefixSums[i] - prefixSums[i - k];
          dp[i][kk] = dp[i - k][kk - 1] + subarraySum;
          prev[i][kk] = take_subarray;
        }

        // 2. skip it
        if (dp[i][kk] <= dp[i - 1][kk]) {
          dp[i][kk] = dp[i - 1][kk];
          prev[i][kk] = skip;
        }

      }
      

    }

    
    int ans = dp[n][subarrays];

    int cn = n;
    int ck = subarrays;
    List<Integer> indices = new ArrayList<>();
    while (prev[cn][ck] != -1) {
      int action = prev[cn][ck];
      if (action == take_subarray) {
        cn = cn - k;
        indices.add(cn);
        ck = ck - 1;
      } else {
        cn = cn - 1;
      }
    }
    Collections.reverse(indices);
  
    int[] ret = new int[indices.size()];
    for (int i = 0; i < indices.size(); i++) {
      ret[i] = indices.get(i);
    }

    return ret;


  }

}
