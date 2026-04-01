class Solution {
    void Dfs(int i, int[] arr, List<List<int>> res) {
        if (i == arr.Length) {
            res.Add(new List<int>(arr));
            return;
        }
        for (int j = i; j < arr.Length; j++) {
            int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            Dfs(i + 1, arr, res);
            t = arr[i]; arr[i] = arr[j]; arr[j] = t;
        }
    }

    public List<List<int>> permuteDist(int[] arr) {
        var res = new List<List<int>>();
        Dfs(0, arr, res);
        return res;
    }
}