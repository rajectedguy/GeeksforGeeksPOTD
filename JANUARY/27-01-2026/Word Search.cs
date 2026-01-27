class Solution {
    int n, m;

    bool Dfs(int i, int j, int idx, char[,] mat, string word) {
        if (idx == word.Length) return true;
        if (i < 0 || j < 0 || i >= n || j >= m || mat[i, j] != word[idx]) return false;

        char temp = mat[i, j];
        mat[i, j] = '#';

        bool found = Dfs(i + 1, j, idx + 1, mat, word) ||
                     Dfs(i - 1, j, idx + 1, mat, word) ||
                     Dfs(i, j + 1, idx + 1, mat, word) ||
                     Dfs(i, j - 1, idx + 1, mat, word);

        mat[i, j] = temp;
        return found;
    }

    public bool isWordExist(char[,] mat, string word) {
        n = mat.GetLength(0);
        m = mat.GetLength(1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Dfs(i, j, 0, mat, word)) return true;
            }
        }
        return false;
    }
}