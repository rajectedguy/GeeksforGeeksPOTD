class Solution:
    def largestSwap(self, s):
        #code here
        s=list(s)
        n=len(s)
        max_ind=n-1
        l=r=-1
        for i in range(n-1,-1,-1):
            if s[i]>s[max_ind]:
                max_ind=i
            elif s[i]<s[max_ind]:
                l=i
                r=max_ind
        if l!=-1:
            s[l],s[r]=s[r],s[l]
        return "".join(s)