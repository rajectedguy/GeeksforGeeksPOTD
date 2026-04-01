class Solution {
    /**
     * @param {string[]} arr
     * @param {number} k
     * @returns {number}
     */
    catchThieves(arr, k) {
        const police = [];
        const thieves = [];
        const n = arr.length;
        let caught = 0;

        // Collect indices of policemen and thieves
        for (let i = 0; i < n; i++) {
            if (arr[i] === 'P') police.push(i);
            else if (arr[i] === 'T') thieves.push(i);
        }

        let p = 0, t = 0;
        while (p < police.length && t < thieves.length) {
            if (Math.abs(police[p] - thieves[t]) <= k) {
                caught++;
                p++;
                t++;
            } else if (police[p] < thieves[t]) {
                p++;
            } else {
                t++;
            }
        }

        return caught;
    }
}