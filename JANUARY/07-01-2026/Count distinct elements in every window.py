class Solution:
    def countDistinct(self, arr, k):
        from collections import defaultdict
        
        freq = defaultdict(int)
        res = []
        
        for i in range(len(arr)):
            freq[arr[i]] += 1
            
            if i >= k - 1:
                res.append(len(freq))
                
                left = arr[i - k + 1]
                freq[left] -= 1
                if freq[left] == 0:
                    del freq[left]
                    
        return res