class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        int ret = 0;
        while (x != 0) {
            int r = x % 10;
            x /= 10;
            int newRet = ret * 10 + r;
            if (newRet % 10 != r) {
                return 0;
            }
            ret = newRet;
        }
        if (negative) {
            ret = -ret;
        }
        return ret;
    }
}