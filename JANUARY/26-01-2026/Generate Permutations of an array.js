class Solution {
    permuteDist(arr) {
        const res = [];
        
        const dfs = (i) => {
            if (i === arr.length) {
                res.push([...arr]);
                return;
            }
            for (let j = i; j < arr.length; j++) {
                [arr[i], arr[j]] = [arr[j], arr[i]];
                dfs(i + 1);
                [arr[i], arr[j]] = [arr[j], arr[i]];
            }
        };
        
        dfs(0);
        return res;
    }
}