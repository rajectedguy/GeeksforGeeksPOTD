/**
 * @param {number} n
 * @param {number} k
 * @returns {number}
 */
class Solution {
    josephus(n, k) {
        let res = 0;
        for (let i = 1; i <= n; i++)
            res = (res + k) % i;
        return res + 1;
    }
}