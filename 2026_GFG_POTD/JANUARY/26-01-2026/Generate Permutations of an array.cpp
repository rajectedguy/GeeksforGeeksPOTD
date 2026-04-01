class Solution {
  public:
    void dfs(int i, vector<int>& arr, vector<vector<int>>& res) {
        if (i == arr.size()) {
            res.push_back(arr);
            return;
        }
        for (int j = i; j < arr.size(); j++) {
            swap(arr[i], arr[j]);
            dfs(i + 1, arr, res);
            swap(arr[i], arr[j]);
        }
    }
    
    vector<vector<int>> permuteDist(vector<int>& arr) {
        vector<vector<int>> res;
        dfs(0, arr, res);
        return res;
    }
};