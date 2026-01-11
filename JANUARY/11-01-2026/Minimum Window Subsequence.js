class Solution {
    minWindow(s1, s2) {
        const n = s1.length, m = s2.length;
        const dp = Array.from({ length: n + 1 }, () => Array(m + 1).fill(-1));

        for (let i = 0; i <= n; i++) dp[i][0] = i;

        for (let i = 1; i <= n; i++) {
            for (let j = 1; j <= m; j++) {
                if (s1[i - 1] === s2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        let len = Infinity, start = -1;
        for (let i = 1; i <= n; i++) {
            if (dp[i][m] !== -1) {
                const curr = i - dp[i][m];
                if (curr < len) {
                    len = curr;
                    start = dp[i][m];
                }
            }
        }

        if (start === -1) return "";
        return s1.substring(start, start + len);
    }
}