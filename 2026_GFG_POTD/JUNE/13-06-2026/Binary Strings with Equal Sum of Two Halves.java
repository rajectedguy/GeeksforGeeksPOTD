class Solution {
    private static final int MOD = 1000000007;
    public int computeValue(int n) {
        int limit = 2 * n;
        long[] fact = new long[limit + 1];
        fact[0] = 1;
        for (int i = 1; i <= limit; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        long num = fact[2 * n];
        long den = (fact[n] * fact[n]) % MOD;
        long ans = (num * power(den, MOD - 2)) % MOD;
        return (int) ans;
    }
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}