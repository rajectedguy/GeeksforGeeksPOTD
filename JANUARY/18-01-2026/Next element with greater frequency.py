from collections import Counter
class Solution:
    def nextFreqGreater(self, arr):
        dic=Counter(arr)
        ans=[]
        stack=[]
        for i in arr[::-1]:
            while stack and stack[-1][0]<=dic[i]:
                stack.pop()
            if stack:
                ans.append(stack[-1][1])
            else:
                ans.append(-1)
            stack.append([dic[i],i])
        return ans[::-1]