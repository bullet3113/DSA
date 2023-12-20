// https://leetcode.com/problems/path-with-minimum-effort

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int dir[][] = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int n = heights.length;
        int m = heights[0].length;

        int ans[][] = new int[n][m];

        for(int[] a: ans) Arrays.fill(a, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        pq.add(new int[] {0, 0, 0});
        ans[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] temp = pq.remove();
            int wt = temp[0]; int x = temp[1]; int y = temp[2];

            if(x == n-1 && y == m-1) return wt;

            for(int i = 0; i < 4; i++) {
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];

                if(newX >= 0 && newY >= 0 && newX < n && newY < m) {

                    int newAns = Math.max(wt, Math.abs(heights[x][y] - heights[newX][newY]));

                    if(newAns < ans[newX][newY]) {
                        ans[newX][newY] = newAns;
                        pq.add(new int[] {newAns, newX, newY});
                    }

                    
                }
            }
        }

        return 0;
    }
}