using System;
using System.Collections.Generic;

class Solution {
    public int catchThieves(char[] arr, int k) {
        List<int> police = new List<int>();
        List<int> thieves = new List<int>();
        int n = arr.Length;
        int caught = 0;

        // Collect indices of police and thieves
        for (int idx = 0; idx < n; idx++) {
            if (arr[idx] == 'P') police.Add(idx);
            else if (arr[idx] == 'T') thieves.Add(idx);
        }

        int p = 0, t = 0;
        while (p < police.Count && t < thieves.Count) {
            if (Math.Abs(police[p] - thieves[t]) <= k) {
                caught++;
                p++;
                t++;
            } else if (police[p] < thieves[t]) {
                p++;
            } else {
                t++;
            }
        }

        return caught;
    }
}