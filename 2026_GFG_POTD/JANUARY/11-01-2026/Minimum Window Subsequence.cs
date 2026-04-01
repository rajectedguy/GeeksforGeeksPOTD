class Solution {
    public string minWindow(string s1, string s2) {
        int n = s1.Length, m = s2.Length;
        int[,] dp = new int[n + 1, m + 1];

        for (int i = 0; i <= n; i++) dp[i, 0] = i;
        for (int j = 1; j <= m; j++) dp[0, j] = -1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i - 1] == s2[j - 1])
                    dp[i, j] = dp[i - 1, j - 1];
                else
                    dp[i, j] = dp[i - 1, j];
            }
        }

        int len = int.MaxValue, start = -1;
        for (int i = 1; i <= n; i++) {
            if (dp[i, m] != -1) {
                int curr = i - dp[i, m];
                if (curr < len) {
                    len = curr;
                    start = dp[i, m];
                }
            }
        }

        if (start == -1) return "";
        return s1.Substring(start, len);
    }
}