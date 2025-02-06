class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            num = digitSum(num);
        }
        return num;
    }

    int digitSum(int num) {
        int ret = 0;
        while (num != 0) {
            ret += (num % 10);
            num /= 10;
        }
        return ret;
    }

}