// https://leetcode.com/problems/number-of-provinces

class Solution {
    public int findCircleNum(int[][] matrix) {
        // creating graph
        int n = matrix.length;
        int m = matrix[0].length;

        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        // finding connected components
        boolean[] vis = new boolean[n];

        int c = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfs(adj, i, vis);
                c++;
            }
        }

        return c;
    }

    void dfs(ArrayList<Integer>[] adj, int src, boolean[] vis) {
        vis[src] = true;

        for(int val: adj[src]) {
            if(!vis[val]) dfs(adj, val, vis);
        }
    }
}