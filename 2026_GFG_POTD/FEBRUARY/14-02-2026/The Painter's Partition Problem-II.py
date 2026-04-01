class Solution:
    def minTime (self, arr, k):
        def ok(mid):
            currSum, cnt = 0, 1
            for ele in arr:
                if currSum + ele > mid:
                    currSum = ele
                    cnt += 1
                    if cnt > k:
                        return False
                else:
                    currSum += ele
            return cnt <= k
            
            
        l, h = max(arr), sum(arr)
        res = max(arr)
        while l <= h:
            mid = l+(h-l)//2
            if ok(mid):
                res = mid
                h = mid-1
            else:
                l = mid+1
        return res