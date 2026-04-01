class Solution:
    def minWindow(self, s1, s2):
        n, m = len(s1), len(s2)
        dp = [[-1] * (m + 1) for _ in range(n + 1)]

        for i in range(n + 1):
            dp[i][0] = i

        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if s1[i - 1] == s2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = dp[i - 1][j]

        length = float('inf')
        start = -1

        for i in range(1, n + 1):
            if dp[i][m] != -1:
                curr = i - dp[i][m]
                if curr < length:
                    length = curr
                    start = dp[i][m]

        if start == -1:
            return ""
        return s1[start:start + length]