class Solution {
    isWordExist(mat, word) {
        const n = mat.length, m = mat[0].length;

        const dfs = (i, j, idx) => {
            if (idx === word.length) return true;
            if (i < 0 || j < 0 || i >= n || j >= m || mat[i][j] !== word[idx]) return false;

            const temp = mat[i][j];
            mat[i][j] = '#';

            const found = dfs(i + 1, j, idx + 1) ||
                          dfs(i - 1, j, idx + 1) ||
                          dfs(i, j + 1, idx + 1) ||
                          dfs(i, j - 1, idx + 1);

            mat[i][j] = temp;
            return found;
        };

        for (let i = 0; i < n; i++) {
            for (let j = 0; j < m; j++) {
                if (dfs(i, j, 0)) return true;
            }
        }
        return false;
    }
}