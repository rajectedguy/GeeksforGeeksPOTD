class Solution:
    def maxSubarrayXOR(self, arr, k):
        n = len(arr)
        if k > n:
            return 0
        
        xor_sum = 0
        for i in range(k):
            xor_sum ^= arr[i]
        
        max_xor = xor_sum
        
        for i in range(k, n):
            xor_sum ^= arr[i] ^ arr[i - k]
            max_xor = max(max_xor, xor_sum)
        
        return max_xor