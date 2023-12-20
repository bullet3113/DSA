// https://leetcode.com/problems/number-of-enclaves

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
	  int m = grid[0].length;

	  boolean vis[][] = new boolean[n][m];

	  int count = 0;
	  for(int i = 0; i < n; i++) {
		  for(int j = 0; j < m; j++) {
			  if(i == 0 || j == 0 || i == n-1 || j == m-1) {
				  if(!vis[i][j] || grid[i][j] == 1)
					  drawTree(grid, i, j, vis);
			  } 
		  }		  
	  }

	  for(int i = 0; i < n; i++) {
		  for(int j = 0; j < m; j++) {
			  if(i == 0 || j == 0 || i == n-1 || j == m-1) {
				  continue;
			  } else if(grid[i][j] == 1 && !vis[i][j]) count++;
		  }		  
	  }
	  return count;
    }

     void drawTree(int[][] grid, int i, int j, boolean[][] vis) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || vis[i][j]) {
			return;
		}

		vis[i][j] = true;

		drawTree(grid, i + 1, j, vis);
		drawTree(grid, i, j + 1, vis);
		drawTree(grid, i - 1, j, vis);
		drawTree(grid, i, j - 1, vis);
	}
}