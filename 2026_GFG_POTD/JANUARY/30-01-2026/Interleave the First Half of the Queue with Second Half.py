class Solution:
    def rearrangeQueue(self, q):
        l=len(q)
        half=l//2
        q1,q2=deque(), deque()
        
        for i in range(half):
            q1.append(q.popleft())
        for i in range(half, l):
            q2.append(q.popleft())

        while q1 and q2:
            q.append(q1.popleft())
            q.append(q2.popleft())