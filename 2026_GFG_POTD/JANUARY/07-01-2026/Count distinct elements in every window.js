class Solution {
    countDistinct(arr, k) {
        const res = [];
        const freq = new Map();
        
        for (let i = 0; i < arr.length; i++) {
            freq.set(arr[i], (freq.get(arr[i]) || 0) + 1);
            
            if (i >= k - 1) {
                res.push(freq.size);
                
                const left = arr[i - k + 1];
                freq.set(left, freq.get(left) - 1);
                if (freq.get(left) === 0) freq.delete(left);
            }
        }
        
        return res;
    }
}