class Solution {
    
    public void dfs(int[][] grid , boolean[][] visited , int m , int n , int r , int c){
        
        visited[r][c] = true;
        
        int[][] neighbors = {{r - 1,c},{r , c + 1},{r + 1, c},{r , c - 1}};
        
        for(int[] neigh : neighbors){
            int nr = neigh[0];
            int nc = neigh[1];
            
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] == 1){
                dfs(grid , visited , m , n , nr , nc);
            }
        }
    }
    int cntOnes(int[][] grid) {
        // code here
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if((i == 0 || i == m - 1) && grid[i][j] == 1){
                    if(!visited[i][j]){
                        dfs(grid , visited , m , n , i , j);
                    }
                }
                if((j == 0 || j == n - 1) && grid[i][j] == 1){
                    if(!visited[i][j]){
                        dfs(grid , visited , m , n , i , j);
                    }
                }
            }
        }
        
        int unVisitedCell = 0;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
        
                if(!visited[i][j] && grid[i][j] == 1){
                    unVisitedCell++;
                }
            }
    
        }
        return unVisitedCell;
    }
}