class Solution:
    def countSubarrays(self, arr, k):
        from collections import defaultdict
        
        count_map = defaultdict(int)
        count_map[0] = 1
        prefix_sum = 0
        result = 0
        
        for num in arr:
            if num % 2 != 0:
                prefix_sum += 1
            
            result += count_map[prefix_sum - k]
            
            count_map[prefix_sum] += 1
        
        return result