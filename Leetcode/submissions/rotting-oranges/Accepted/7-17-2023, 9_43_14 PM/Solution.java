// https://leetcode.com/problems/rotting-oranges

class pair {
    int i;
    int j;
    int time;

    public pair(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0, c = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean vis[][] = new boolean[n][m];

        Queue<pair> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new pair(i, j, 0));   
                    c++;
                } else if(grid[i][j] == 1) c++;
            }
        }

        while(!q.isEmpty()) {
            pair dq = q.remove();

            int x = dq.i;
            int y = dq.j;
            int time = dq.time;

            if(vis[x][y]) continue;
            vis[x][y] = true;

            // move in 4 direction
            for(int i = 0; i < 4; i++) {
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];

                if(newX >= 0 && newY >= 0 && newX < n && newY < m) {

                    if(!vis[newX][newY] && grid[newX][newY] == 1) q.add(new pair(newX, newY, time + 1));
                    // else if(grid[newX][newY] == 1) grid[newX][newY] = 2;

                }
            }

            ans = Math.max(ans, time);
            c--;
        }

        if(c > 0) return -1;
        return ans;
    }
}