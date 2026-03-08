class Solution:
    def pythagoreanTriplet(self, arr):
        s = set()

        for x in arr:
            s.add(x * x)

        n = len(arr)

        for i in range(n):
            for j in range(i + 1, n):
                if arr[i]*arr[i] + arr[j]*arr[j] in s:
                    return True

        return False