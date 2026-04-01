/**
 * @param {number[]} arr
 * @param {number} k
 * @returns {number}
 */
class Solution {
    countSubarrays(arr, k) {
        const countMap = new Map();
        countMap.set(0, 1);
        let prefixSum = 0;
        let result = 0;
        for (let num of arr) {
            if (num % 2 !== 0) prefixSum += 1;
            if (countMap.has(prefixSum - k)) {
                result += countMap.get(prefixSum - k);
            }
            countMap.set(prefixSum, (countMap.get(prefixSum) || 0) + 1);
        }
        return result;
    }
}