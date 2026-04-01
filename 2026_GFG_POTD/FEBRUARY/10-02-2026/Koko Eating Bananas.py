class Solution:
    def kokoEat(self, arr, k):
        low,high=1,max(arr)
        
        while low<=high:
            mid=(low+high)//2
            
            hours=0
            
            for bananas in arr:
                hours+=(bananas+mid-1)//mid
            if hours<=k:
                high=mid-1
            else:
                low=mid+1
        return low