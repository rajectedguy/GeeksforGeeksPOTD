class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;
        int xorSum = 0;
        for (int i = 0; i < k; i++) xorSum ^= arr[i];
        int maxXor = xorSum;
        for (int i = k; i < n; i++) {
            xorSum ^= arr[i] ^ arr[i - k];
            maxXor = Math.max(maxXor, xorSum);
        }
        return maxXor;
    }
}