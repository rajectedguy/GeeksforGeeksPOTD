import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        int[] dist = new int[1000];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int x : arr) {
                int next = (curr * x) % 1000;
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    if (next == end) {
                        return dist[next];
                    }
                    q.add(next);
                }
            }
        }
        return -1;
    }
}