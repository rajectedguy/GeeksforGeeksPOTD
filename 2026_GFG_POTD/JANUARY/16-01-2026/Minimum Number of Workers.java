class Solution {
    public int minMen(int[] arr) {
        int n = arr.length;
        int[][] intervals = new int[n][2];
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int start = Math.max(0, i - arr[i]);
                int end = Math.min(n - 1, i + arr[i]);
                intervals[idx][0] = start;
                intervals[idx][1] = end;
                idx++;
            }
        }
        
        if (idx == 0) return -1;
        
        java.util.Arrays.sort(intervals, 0, idx, (a, b) -> a[0] - b[0]);
        
        int ans = 0, i = 0, covered = 0, farthest = -1;
        while (covered < n) {
            boolean found = false;
            while (i < idx && intervals[i][0] <= covered) {
                farthest = Math.max(farthest, intervals[i][1]);
                i++;
                found = true;
            }
            if (!found) return -1;
            covered = farthest + 1;
            ans++;
        }
        return ans;
    }
}