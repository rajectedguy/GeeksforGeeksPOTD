class Solution {
    Long[][] dp;
    long mod = (long)1e9 + 7;
    public int ways(int x, int y) {
        dp = new Long[x + 1][y + 1];
        return (int)solve(x, y);
    }
    long solve(int x, int y) {
        if(x == 0 && y == 0) return 1;
        if(x < 0 || y < 0) return 0;
        if(dp[x][y] != null) return dp[x][y];
        return dp[x][y] = ((solve(x - 1, y) % mod) + (solve(x, y - 1)) % mod) % mod;
    }
}