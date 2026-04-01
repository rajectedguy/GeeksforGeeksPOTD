class Solution:
    def permuteDist(self, arr):
        res = []
        
        def dfs(i):
            if i == len(arr):
                res.append(arr[:])
                return
            for j in range(i, len(arr)):
                arr[i], arr[j] = arr[j], arr[i]
                dfs(i + 1)
                arr[i], arr[j] = arr[j], arr[i]
        
        dfs(0)
        return res