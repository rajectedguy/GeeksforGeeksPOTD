class Solution {
    findWays(n) {
        if (n % 2) return 0;
        const k = n / 2;
        const dp = Array(k + 1).fill(0);
        dp[0] = dp[1] = 1;
        for (let i = 2; i <= k; i++)
            for (let j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i - j - 1];
        return dp[k];
    }
}