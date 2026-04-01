class Solution {
  public:
    string minWindow(string& s1, string& s2) {
        int n = s1.size(), m = s2.size();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, -1));
        
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        
        int len = INT_MAX, start = -1;
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
        return s1.substr(start, len);
    }
};