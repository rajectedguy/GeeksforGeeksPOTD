class Solution:
    def overlapInt(self, arr):
        n = len(arr)
        
        start = sorted([interval[0] for interval in arr])
        end = sorted([interval[1] for interval in arr])
        
        i = 0
        j = 0
        curr_overlap = 0
        max_overlap = 0
        
        while i < n and j < n:
            if start[i] <= end[j]:
                curr_overlap += 1
                max_overlap = max(max_overlap, curr_overlap)
                i += 1
            else:
                curr_overlap -= 1
                j += 1
                
        return max_overlap