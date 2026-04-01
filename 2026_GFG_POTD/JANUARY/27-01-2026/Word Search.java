class Solution {
    int n, m;

    boolean dfs(int i, int j, int idx, char[][] mat, String word) {
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i >= n || j >= m || mat[i][j] != word.charAt(idx)) return false;

        char temp = mat[i][j];
        mat[i][j] = '#';

        boolean found = dfs(i + 1, j, idx + 1, mat, word) ||
                        dfs(i - 1, j, idx + 1, mat, word) ||
                        dfs(i, j + 1, idx + 1, mat, word) ||
                        dfs(i, j - 1, idx + 1, mat, word);

        mat[i][j] = temp;
        return found;
    }

    public boolean isWordExist(char[][] mat, String word) {
        n = mat.length;
        m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0, mat, word)) return true;
            }
        }
        return false;
    }
}