using System;
using System.Collections.Generic;

public class Solution {
    public int minMen(int[] arr) {
        int n = arr.Length;
        List<(int start, int end)> intervals = new List<(int, int)>();
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int start = Math.Max(0, i - arr[i]);
                int end = Math.Min(n - 1, i + arr[i]);
                intervals.Add((start, end));
            }
        }
        
        if (intervals.Count == 0) return -1;
        
        intervals.Sort((a, b) => a.start.CompareTo(b.start));
        
        int ans = 0;
        int iIndex = 0;
        int covered = 0;
        int farthest = -1;
        
        while (covered < n) {
            bool found = false;
            while (iIndex < intervals.Count && intervals[iIndex].start <= covered) {
                farthest = Math.Max(farthest, intervals[iIndex].end);
                iIndex++;
                found = true;
            }
            if (!found) return -1;
            covered = farthest + 1;
            ans++;
        }
        
        return ans;
    }
}