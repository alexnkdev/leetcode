class Solution {
    public boolean isBalanced(String num) {
       int sumOdd = 0;
       int sumEven = 0;
       for (int i = 0; i < num.length(); i++) {
         if (i % 2 == 1) {
            sumOdd += (int)(num.charAt(i) - '0');
         } else {
            sumEven += (int)(num.charAt(i) - '0');
         }
       }
       return sumOdd == sumEven; 
    }
}