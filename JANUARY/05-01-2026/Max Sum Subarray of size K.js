class Solution {
    /**
     * @param {number[]} arr
     * @param {number} k
     * @return {number}
     */
    maxSubarraySum(arr, k) {
        let n = arr.length;
        let windowSum = 0, maxSum = 0;
        for (let i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        for (let i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            if (windowSum > maxSum) maxSum = windowSum;
        }
        return maxSum;
    }
}