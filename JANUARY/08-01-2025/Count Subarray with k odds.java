import java.util.HashMap;

class Solution {
    public int countSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        int prefixSum = 0;
        int result = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                prefixSum += 1;
            }
            result += countMap.getOrDefault(prefixSum - k, 0);
            countMap.put(prefixSum, countMap.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}