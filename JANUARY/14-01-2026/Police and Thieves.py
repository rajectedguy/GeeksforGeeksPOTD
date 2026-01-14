class Solution:
    def catchThieves(self, arr, k):
        police = []
        thieves = []
        n = len(arr)
        caught = 0

        for i in range(n):
            if arr[i] == 'P':
                police.append(i)
            elif arr[i] == 'T':
                thieves.append(i)

        i = j = 0
        while i < len(police) and j < len(thieves):
            if abs(police[i] - thieves[j]) <= k:
                caught += 1
                i += 1
                j += 1
            elif police[i] < thieves[j]:
                i += 1
            else:
                j += 1

        return caught