from collections import deque, defaultdict

class Solution:
    # Platform expects method name: firstNonRepeating
    def firstNonRepeating(self, s):
        from collections import deque
        appeared_count = [0] * 26
        appeared_queue = deque()
        ans = []
        for c in s:
            i = ord(c) - ord("a")
            appeared_count[i] += 1
            if appeared_count[i] == 1:
                appeared_queue.append(i)
            while appeared_queue and appeared_count[appeared_queue[0]] > 1:
                appeared_queue.popleft()
            if appeared_queue:
                ans.append(chr(appeared_queue[0] + ord("a")))
            else:
                ans.append("#")
        return "".join(ans)