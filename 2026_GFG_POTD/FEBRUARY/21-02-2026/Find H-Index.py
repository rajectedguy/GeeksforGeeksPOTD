class Solution:
    def hIndex(self, citations):
        citations.sort()
        n = len(citations)
        max_val = 0
        for i in range(n):
            curr_diff = n-i
            curr_val = citations[i]
            if curr_val >= curr_diff:
                max_val=curr_diff
                return max_val
        return max_val