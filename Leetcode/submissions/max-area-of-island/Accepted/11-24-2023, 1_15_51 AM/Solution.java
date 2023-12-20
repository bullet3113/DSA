// https://leetcode.com/problems/max-area-of-island

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    ans = Math.max(ans, helper(grid, i, j, vis));
                    
                }
            }
        }
        return ans;
    }


    int helper(int[][] grid, int i, int j, boolean[][] vis) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == 0) return 0;
        int count = 0;
        if(!vis[i][j]) count = 1;
        vis[i][j] = true;
        return helper(grid, i+1, j, vis) +
        helper(grid, i-1, j, vis) +
        helper(grid, i, j+1, vis) +
        helper(grid, i, j-1, vis) + count;
    }
}