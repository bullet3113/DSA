// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    helper(grid, i, j, vis);
                    ans++;
                }
            }
        }

        return ans;
    }

    void helper(char[][] grid, int i, int j, boolean[][] vis) {

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == '0') return;

        vis[i][j] = true;

        helper(grid, i+1, j, vis);
        helper(grid, i-1, j, vis);
        helper(grid, i, j+1, vis);
        helper(grid, i, j-1, vis);
    }
}