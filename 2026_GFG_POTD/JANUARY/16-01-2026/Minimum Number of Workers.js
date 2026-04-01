class Solution {
    minMen(arr) {
        const n = arr.length;
        const intervals = [];
        
        // Build intervals
        for (let i = 0; i < n; i++) {
            if (arr[i] !== -1) {
                const start = Math.max(0, i - arr[i]);
                const end = Math.min(n - 1, i + arr[i]);
                intervals.push([start, end]);
            }
        }
        
        if (intervals.length === 0) return -1;
        
        // Sort intervals by start
        intervals.sort((a, b) => a[0] - b[0]);
        
        let ans = 0;
        let i = 0;
        let covered = 0;
        let farthest = -1;
        
        while (covered < n) {
            let found = false;
            while (i < intervals.length && intervals[i][0] <= covered) {
                farthest = Math.max(farthest, intervals[i][1]);
                i++;
                found = true;
            }
            if (!found) return -1; // gap found
            covered = farthest + 1;
            ans++;
        }
        
        return ans;
    }
}