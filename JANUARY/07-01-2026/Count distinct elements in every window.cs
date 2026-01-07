using System;
using System.Collections.Generic;

class Solution {
    public List<int> countDistinct(int[] arr, int k) {
        List<int> res = new List<int>();
        Dictionary<int, int> freq = new Dictionary<int, int>();
        
        for (int i = 0; i < arr.Length; i++) {
            if (freq.ContainsKey(arr[i]))
                freq[arr[i]]++;
            else
                freq[arr[i]] = 1;
            
            if (i >= k - 1) {
                res.Add(freq.Count);
                
                int left = arr[i - k + 1];
                freq[left]--;
                if (freq[left] == 0)
                    freq.Remove(left);
            }
        }
        
        return res;
    }
}