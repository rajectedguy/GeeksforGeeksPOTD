class Solution:
    def findKRotation(self, arr):
        # code here
        if arr[0] <= arr[-1]:
            return 0
        lo, hi = 0, len(arr)
        while lo < hi:
            mi = lo + (hi-lo)//2
            if arr[mi] < arr[0]:
                hi = mi
            else:
                lo = mi+1
        return lo