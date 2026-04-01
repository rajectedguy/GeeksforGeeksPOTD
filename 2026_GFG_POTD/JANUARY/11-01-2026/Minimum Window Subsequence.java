class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 1; j <= m; j++) dp[0][j] = -1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        int len = Integer.MAX_VALUE, start = -1;
        for (int i = 1; i <= n; i++) {
            if (dp[i][m] != -1) {
                int currLen = i - dp[i][m];
                if (currLen < len) {
                    len = currLen;
                    start = dp[i][m];
                }
            }
        }

        if (start == -1) return "";
        return s1.substring(start, start + len);
    }
}