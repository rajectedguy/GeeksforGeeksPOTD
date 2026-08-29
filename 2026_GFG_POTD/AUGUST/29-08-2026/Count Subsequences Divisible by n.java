class Solution {
    public int countSubsequences(String s, int n) {
        final long MOD = 1_000_000_007L;
        long[] dp = new long[n];
        for (char ch : s.toCharArray()) {
            int d = ch - '0';
            long[] next = dp.clone();
            int rem = d % n;
            next[rem] = (next[rem] + 1) % MOD;
            for (int r = 0; r < n; r++) {
                if (dp[r] != 0) {
                    int newRem = (r * 10 + d) % n;
                    next[newRem] = (next[newRem] + dp[r]) % MOD;
                }
            }
            dp = next;
        }
        return (int) dp[0];
    }
}