class Solution {
    /**
     * @param {number[]} arr
     * @param {number} k
     * @returns {number}
     */
    maxSubarrayXOR(arr, k) {
        const n = arr.length;
        if (k > n) return 0;

        let xorSum = 0;
        for (let i = 0; i < k; i++) xorSum ^= arr[i];

        let maxXor = xorSum;

        for (let i = k; i < n; i++) {
            xorSum ^= arr[i] ^ arr[i - k];
            if (xorSum > maxXor) maxXor = xorSum;
        }

        return maxXor;
    }
}