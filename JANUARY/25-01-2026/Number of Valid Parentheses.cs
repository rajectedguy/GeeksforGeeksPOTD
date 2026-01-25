class Solution {
    public int findWays(int n) {
        if ((n & 1) == 1) return 0;
        int k = n / 2;
        long[] dp = new long[k + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= k; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i - j - 1];
        return (int)dp[k];
    }
}