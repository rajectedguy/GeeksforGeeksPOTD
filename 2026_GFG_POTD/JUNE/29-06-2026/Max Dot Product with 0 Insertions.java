class Solution {
 int[][] dp;
    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(a, b, 0, 0);
    }
    private int solve(int[] a, int[] b, int i, int j) {
        int n = a.length;
        int m = b.length;
        if (j == m) {
            return 0;
        }
        if (i == n) {
            return Integer.MIN_VALUE;
        }
        if (n - i < m - j) {
            return Integer.MIN_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int skip = solve(a, b, i + 1, j);
        int match = a[i] * b[j];
        int next = solve(a, b, i + 1, j + 1);
        if (next != Integer.MIN_VALUE) {
            match += next;
        }
        return dp[i][j] = Math.max(skip, match);
    }
}