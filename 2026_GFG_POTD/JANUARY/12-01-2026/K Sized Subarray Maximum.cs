using System;
using System.Collections.Generic;

public class Solution {
    public List<int> maxOfSubarrays(int[] arr, int k) {
        List<int> res = new List<int>();
        LinkedList<int> dq = new LinkedList<int>();

        for (int i = 0; i < arr.Length; i++) {
            while (dq.Count > 0 && dq.First.Value <= i - k)
                dq.RemoveFirst();
            while (dq.Count > 0 && arr[dq.Last.Value] <= arr[i])
                dq.RemoveLast();
            dq.AddLast(i);
            if (i >= k - 1)
                res.Add(arr[dq.First.Value]);
        }

        return res;
    }
}