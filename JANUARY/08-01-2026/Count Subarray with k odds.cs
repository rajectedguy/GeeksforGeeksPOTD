using System;
using System.Collections.Generic;

class Solution
{
    public int countSubarrays(int[] arr, int k)
    {
        Dictionary<int, int> countMap = new Dictionary<int, int>();
        countMap[0] = 1;
        int prefixSum = 0;
        int result = 0;
        foreach (int num in arr)
        {
            if (num % 2 != 0)
                prefixSum += 1;
            if (countMap.ContainsKey(prefixSum - k))
                result += countMap[prefixSum - k];
            if (countMap.ContainsKey(prefixSum))
                countMap[prefixSum]++;
            else
                countMap[prefixSum] = 1;
        }
        return result;
    }
}