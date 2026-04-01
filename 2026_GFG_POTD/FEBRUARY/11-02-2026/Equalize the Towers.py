class Solution:
     def minCost(self, heights, cost):
        pairs = sorted(zip(heights, cost), key=lambda x: x[0])
        total_heights = sum(cost)

        acc, n = 0, len(pairs)
        i = 0
        while i < n:
            acc += pairs[i][1]
            if acc >= total_heights/2:
                break
            i += 1
        return sum(abs(h - pairs[i][0])*c for h, c in pairs)