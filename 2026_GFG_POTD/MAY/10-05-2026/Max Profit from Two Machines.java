import java.util.*;

class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        Integer[] diff = new Integer[n];
        long totalProfit = 0;
        for (int i = 0; i < n; i++) {
            totalProfit += b[i];
            diff[i] = a[i] - b[i];
        }
        Arrays.sort(diff, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (i < (n - y)) {
                totalProfit += diff[i];
                x--;
            }
            else if (x > 0 && diff[i] > 0) {
                totalProfit += diff[i];
                x--;
            }
        }
        return (int) totalProfit;
    }
}