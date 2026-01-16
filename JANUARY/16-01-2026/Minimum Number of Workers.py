class Solution:
    def minMen(self, arr):
        n = len(arr)
        intervals = []
        
        # Build intervals for each available person
        for i, val in enumerate(arr):
            if val != -1:
                start = max(0, i - val)
                end = min(n - 1, i + val)
                intervals.append((start, end))
        
        if not intervals:
            return -1
        
        # Sort intervals by start
        intervals.sort()
        
        ans = 0
        i = 0
        covered = 0
        farthest = -1
        
        while covered < n:
            found = False
            while i < len(intervals) and intervals[i][0] <= covered:
                farthest = max(farthest, intervals[i][1])
                i += 1
                found = True
            if not found:
                return -1  # gap found
            covered = farthest + 1
            ans += 1
        
        return ans