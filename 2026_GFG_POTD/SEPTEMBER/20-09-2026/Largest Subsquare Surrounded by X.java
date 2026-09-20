class Solution {
    public int largestSubsquare(char mat[][]) {
        int n = mat.length;
        int[][] right = new int[n][n];
        int[][] down = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 'X') {
                    right[i][j] = 1;
                    down[i][j] = 1;
                    if (j + 1 < n) {
                        right[i][j] += right[i][j + 1];
                    }
                    if (i + 1 < n) {
                        down[i][j] += down[i + 1][j];
                    }
                }
            }
        }
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int maxPossible = Math.min(n - i, n - j);
                for (int size = maxPossible; size > maxSize; size--) {
                    int bottom = i + size - 1;
                    int rightCol = j + size - 1;
                    boolean top = right[i][j] >= size;
                    boolean left = down[i][j] >= size;
                    boolean bottomSide = right[bottom][j] >= size;
                    boolean rightSide = down[i][rightCol] >= size;
                    if (top && left && bottomSide && rightSide) {
                        maxSize = size;
                        break;
                    }
                }
            }
        }
        return maxSize;
    }
}