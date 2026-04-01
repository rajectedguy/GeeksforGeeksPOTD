class Solution {
    maxOfSubarrays(arr, k) {
        const res = [];
        const dq = [];

        for (let i = 0; i < arr.length; i++) {
            while (dq.length && dq[0] <= i - k) dq.shift();
            while (dq.length && arr[dq[dq.length - 1]] <= arr[i]) dq.pop();
            dq.push(i);
            if (i >= k - 1) res.push(arr[dq[0]]);
        }

        return res;
    }
}