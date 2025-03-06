class Solution {
    public boolean isUgly(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (n < 0) {
            return false;
        }
        List<Integer> good = List.of(2, 3, 5);
        List<Integer> factors = new ArrayList<>();
        int current = 3;
        if (n % 2 == 0) {
            factors.add(2);
            while (n % 2 == 0) {
                n /= 2;
            }
        }
        int max = (int) Math.ceil(Math.sqrt(n));
        while (current <= max) {
            if (n % current == 0) {
                factors.add(current);
            }
            while (n % current == 0) {
                n /= current;
            }
            current += 2;
        }
        if (n != 1) {
            factors.add(n);
        }
        for (int f : factors) {
            if (!good.contains(f)) {
                return false;
            }
        }
        return true;
    }
}